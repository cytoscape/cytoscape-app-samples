package org.cytoscape.sample.internal;

import java.awt.Color;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.model.CyTable;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.presentation.property.NodeShapeVisualProperty;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.mappings.BoundaryRangeValues;
import org.cytoscape.view.vizmap.mappings.ContinuousMapping;
import org.cytoscape.view.vizmap.mappings.DiscreteMapping;
import org.cytoscape.view.vizmap.mappings.PassthroughMapping;


public class CreateVisualStyleAction extends AbstractCyAction {

	private static final long serialVersionUID = 1L;
	private CyApplicationManager cyApplicationManagerServiceRef;
	private VisualStyleFactory visualStyleFactoryServiceRef;
	private VisualMappingManager vmmServiceRef;
	
	private VisualMappingFunctionFactory vmfFactoryC;
	private VisualMappingFunctionFactory vmfFactoryD;
	private VisualMappingFunctionFactory vmfFactoryP;
	
	public CreateVisualStyleAction(CyApplicationManager cyApplicationManagerServiceRef, VisualMappingManager vmmServiceRef, VisualStyleFactory visualStyleFactoryServiceRef, 
			VisualMappingFunctionFactory vmfFactoryC,VisualMappingFunctionFactory vmfFactoryD,VisualMappingFunctionFactory vmfFactoryP){
		super("Create Visual Style");
		setPreferredMenu("Apps.Samples");

		this.cyApplicationManagerServiceRef = cyApplicationManagerServiceRef;
		this.visualStyleFactoryServiceRef = visualStyleFactoryServiceRef;
		this.vmmServiceRef =  vmmServiceRef;
		this.vmfFactoryC	= vmfFactoryC;
		this.vmfFactoryD	= vmfFactoryD;
		this.vmfFactoryP	= vmfFactoryP;
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {

		// If the style already existed, remove it first
		Iterator it = vmmServiceRef.getAllVisualStyles().iterator();
		while (it.hasNext()){
			VisualStyle curVS = (VisualStyle)it.next();
			if (curVS.getTitle().equalsIgnoreCase("Sample Visual Style"))
			{
				vmmServiceRef.removeVisualStyle(curVS);
				break;
			}
		}
		
		// Create a new Visual style
		VisualStyle vs= this.visualStyleFactoryServiceRef.createVisualStyle("Sample Visual Style");
		this.vmmServiceRef.addVisualStyle(vs);

		CyTable attrForTest = cyApplicationManagerServiceRef.getCurrentNetwork().getDefaultNodeTable();

		// 1. pass-through mapping
		PassthroughMapping pMapping = (PassthroughMapping) this.vmfFactoryP.createVisualMappingFunction("SUID", String.class, BasicVisualLexicon.NODE_LABEL);
		// 2. DiscreteMapping - Set node shape based on attribute value
		DiscreteMapping dMapping = (DiscreteMapping) this.vmfFactoryD.createVisualMappingFunction("NodeShape", String.class, BasicVisualLexicon.NODE_SHAPE);

		// If attribute value is "diamon", map the nodeShape to DIAMOND
		String key  = "diamond";
		dMapping.putMapValue(key, NodeShapeVisualProperty.DIAMOND);

		// If attribute value is "triangle", map the nodeShape to TRIANGLE
		key  = "triangle";
		dMapping.putMapValue(key, NodeShapeVisualProperty.TRIANGLE);

		//3. continous mapping.
		// Set node color map to attribute "Degree"
		ContinuousMapping cMapping = (ContinuousMapping) this.vmfFactoryC.createVisualMappingFunction("Degree", Integer.class, BasicVisualLexicon.NODE_FILL_COLOR);

		// set the points
		Double val1 = 2d;
		BoundaryRangeValues<Paint> brv1 = new BoundaryRangeValues<Paint>(Color.RED, Color.GREEN, Color.PINK);

		Double val2 = 12d;
		BoundaryRangeValues<Paint> brv2 = new BoundaryRangeValues<Paint>(Color.WHITE, Color.YELLOW, Color.BLACK);

		cMapping.addPoint(val1, brv1);
		cMapping.addPoint(val2, brv2);
		
		vs.addVisualMappingFunction(pMapping);			
		vs.addVisualMappingFunction(dMapping);	
		vs.addVisualMappingFunction(cMapping);	
	}
}
