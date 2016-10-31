package org.cytoscape.sample.customchart.internal;

import static org.cytoscape.model.CyEdge.Type.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyColumn;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.model.VisualLexicon;
import org.cytoscape.view.model.VisualProperty;
import org.cytoscape.view.presentation.customgraphics.CyCustomGraphics2;
import org.cytoscape.view.presentation.customgraphics.CyCustomGraphics2Factory;
import org.cytoscape.view.presentation.property.values.CyColumnIdentifier;
import org.cytoscape.view.presentation.property.values.CyColumnIdentifierFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
import org.cytoscape.work.TunableValidator;
import org.cytoscape.work.util.ListSingleSelection;

public class ChartTask extends AbstractTask implements TunableValidator {
	
	private CyApplicationManager applicationManager;
	private CustomChartListener customChartListener;
	private VisualMappingManager visualMappingManager;
	private CyColumnIdentifierFactory columnIdFactory;

	// Tunable fields are set by the user
	// Note: Callables are used for the selection lists in order to provide a custom toString() method
	// and still be able to get back the selected object.
	
	
	@Tunable(description="Edge Weight Column:")
	public ListSingleSelection<Callable<CyColumn>> columnNames;
	
	@Tunable(description="Edge Type:")
	public ListSingleSelection<CyEdge.Type> edgeTypes = new ListSingleSelection<CyEdge.Type>(ANY, UNDIRECTED, DIRECTED, INCOMING, OUTGOING);
	
	@Tunable(description="Visual Property:")
	public ListSingleSelection<Callable<VisualProperty<CyCustomGraphics2<?>>>> visualProperties;
	
	
	
	public ChartTask(CyApplicationManager applicationManager, CustomChartListener customChartManager, VisualMappingManager visualMappingManager, CyColumnIdentifierFactory columnIdFactory) {
		this.applicationManager = applicationManager;
		this.customChartListener = customChartManager;
		this.visualMappingManager = visualMappingManager;
		this.columnIdFactory = columnIdFactory;
		
		this.columnNames = computeNumericEdgeColumns();
		this.visualProperties = computeVisualProperties();
	}
	
	
	/**
	 * Select the columns from the edge table that are numeric.
	 */
	private ListSingleSelection<Callable<CyColumn>> computeNumericEdgeColumns() {
		CyNetwork network = applicationManager.getCurrentNetwork();
		CyTable edgeTable = network.getDefaultEdgeTable();
		Collection<CyColumn> edgeColumns = edgeTable.getColumns();
		
		List<Callable<CyColumn>> numericColumnNames = new ArrayList<Callable<CyColumn>>();
		
		for(final CyColumn column : edgeColumns) {
			if(Number.class.isAssignableFrom(column.getType()) && !column.isPrimaryKey()) {
				numericColumnNames.add(new Callable<CyColumn>() {
					public CyColumn call() { 
						return column; 
					}
					public String toString() { 
						return column.getName(); 
					}
				});
			}
		}
		
		return new ListSingleSelection<Callable<CyColumn>>(numericColumnNames);
	}
	
	
	/**
	 * Initialize the list of available custom graphics visual properties.
	 */
	@SuppressWarnings("unchecked")
	private ListSingleSelection<Callable<VisualProperty<CyCustomGraphics2<?>>>> computeVisualProperties() {
		Set<VisualLexicon> lexicons = visualMappingManager.getAllVisualLexicon();
		
		List<Callable<VisualProperty<CyCustomGraphics2<?>>>> visualProperties = new ArrayList<Callable<VisualProperty<CyCustomGraphics2<?>>>>();
		for(VisualLexicon lexicon : lexicons) {
			for(int i = 1; i <= 9; i++) {
				
				final VisualProperty<CyCustomGraphics2<?>> visualProperty = 
						(VisualProperty<CyCustomGraphics2<?>>) lexicon.lookup(CyNode.class, "nodeCustomGraphics" + i);
				
				if(visualProperty != null) {
					visualProperties.add(new Callable<VisualProperty<CyCustomGraphics2<?>>>() {
						public VisualProperty<CyCustomGraphics2<?>> call() { 
							return visualProperty; 
						}
						public String toString() { 
							return visualProperty.getDisplayName(); 
						}
					});
				}
			}
		}
		
		return new ListSingleSelection<Callable<VisualProperty<CyCustomGraphics2<?>>>>(visualProperties);
	}
	
	
	public ValidationState getValidationState(Appendable message) {
		return ValidationState.OK;
	}
	
	@Override
	public void run(TaskMonitor monitor) throws Exception {
		monitor.setTitle("Generating Edge Weight Charts");
		
		// Get the values the user selected
		final CyColumn userColumn = columnNames.getSelectedValue().call();
		final CyEdge.Type edgeType = edgeTypes.getSelectedValue();
		final VisualProperty<CyCustomGraphics2<?>> visualProperty = visualProperties.getSelectedValue().call();
		
		monitor.setStatusMessage("Using Column '" + userColumn.getName() + "'");
		monitor.setStatusMessage("Using Visual Property '" + visualProperty.getDisplayName() + "'");
		monitor.setStatusMessage("Creating charts");
		
		// We will create a new column in the node table to store the values the chart will use.
		final String chartColumn = "customCharts";
				
		// Get the graphics factory from the listener.
		CyCustomGraphics2Factory<?> customGraphicsFactory = customChartListener.getFactory();
		
		// Get the current network view
		CyNetworkView networkView = applicationManager.getCurrentNetworkView();
		if(networkView == null) {
			monitor.showMessage(TaskMonitor.Level.ERROR, "No network view");
			return;
		}
		
		CyNetwork network = networkView.getModel();
		
		CyTable nodeTable = network.getTable(CyNode.class, CyNetwork.LOCAL_ATTRS); // create local table
		if(nodeTable.getColumn(chartColumn) == null) {
			nodeTable.createListColumn(chartColumn, Double.class, false);
		}		
		
		// Create a chart for each node
		for(View<CyNode> nodeView : networkView.getNodeViews()) {
			
			// Get the edges for the node
			CyNode node = nodeView.getModel();
			List<CyEdge> edges = network.getAdjacentEdgeList(node, edgeType);
			
			// Use edge weights as values for the chart
			List<Double> chartValues = new ArrayList<Double>(edges.size());
			for(CyEdge edge : edges) {
				CyRow row = network.getRow(edge);
				Number weight = (Number) row.get(userColumn.getName(), userColumn.getType());
				chartValues.add(weight.doubleValue());
			}
			
			// Save the weight value into the node table in the new column we created
			CyRow nodeRow = network.getRow(node);
			nodeRow.set(chartColumn, chartValues);
		}
		
		// Set the chart properties, tell the chart to use the new column we created as the data source.
		CyColumnIdentifier columnId = columnIdFactory.createColumnIdentifier(chartColumn);
		Map<String,Object> chartProps = new HashMap<String, Object>();
		chartProps.put("cy_dataColumns", Arrays.asList(columnId)); 
		chartProps.put("cy_colorScheme", "RAINBOW");
		
		// create the chart instance
		CyCustomGraphics2<?> customGraphics = customGraphicsFactory.getInstance(chartProps);
		
		//String scheme = customGraphics.getProperties().get("cy_colorScheme").toString();

		// Set the custom graphics on the visual style
		VisualStyle visualStyle = visualMappingManager.getCurrentVisualStyle();
		visualStyle.setDefaultValue(visualProperty, customGraphics);
		
		// must do this or charts won't show up instantly
		networkView.updateView();
	}
	

}
