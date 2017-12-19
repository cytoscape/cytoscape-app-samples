package org.cytoscape.legend;

import java.awt.Color;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.annotations.AnnotationFactory;
import org.cytoscape.view.presentation.annotations.AnnotationManager;
import org.cytoscape.view.presentation.annotations.GroupAnnotation;
import org.cytoscape.view.presentation.annotations.ShapeAnnotation;
import org.cytoscape.view.presentation.annotations.TextAnnotation;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.presentation.property.values.LineType;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualPropertyDependency;
import org.cytoscape.view.vizmap.VisualStyle;

public class LegendController {

	private CyServiceRegistrar registrar;
	public LegendController(CyServiceRegistrar reg)
	{
		registrar = reg;
//		initialize();
	}
	//----------------------------------------------------------
	public void createLegend() {

		initialize();
		scanNetwork();
		buildAnnotation();
	}
	//----------------------------------------------------------
	private CyApplicationManager cyApplicationManager;
	private AnnotationManager mgr;
	private CyNetwork network;
	private CyNetworkView networkView;
	private AnnotationFactory<ShapeAnnotation> shapeFactory;
	private AnnotationFactory<TextAnnotation> textFactory;
	private  AnnotationFactory<GroupAnnotation> groupFactory;
	
	//----------------------------------------------------------
	private void initialize()
	{
		cyApplicationManager = registrar.getService(CyApplicationManager.class);

		mgr = registrar.getService(AnnotationManager.class);
		if (mgr == null) 
			System.err.println("AnnotationManager is null");
		shapeFactory =  (AnnotationFactory<ShapeAnnotation>)registrar.getService( AnnotationFactory.class,"(type=ShapeAnnotation.class)");
		if (shapeFactory == null) 
			System.err.println("shapeFactory is null");
		textFactory =  (AnnotationFactory<TextAnnotation>)registrar.getService( AnnotationFactory.class,"(type=TextAnnotation.class)");
		if (textFactory == null) 
			System.err.println("textFactory is null");
		groupFactory =  (AnnotationFactory<GroupAnnotation>)registrar.getService( AnnotationFactory.class,"(type=GroupAnnotation.class)");
		if (groupFactory == null) 
			System.err.println("groupFactory is null");
		
	}
	//-------------------------------------------------------------------
	private void scanNetwork() {

		// Count all the nodes and edges to look for which items might belong in the legend
		
		network = cyApplicationManager.getCurrentNetwork();
		networkView = cyApplicationManager.getCurrentNetworkView();
		if (network == null) return;
		Map<Paint, CyNode> fillColorMap = new HashMap<Paint, CyNode>();
		Map<Paint, CyNode> borderColorMap = new HashMap<Paint, CyNode>();

		List<CyNode> nodes = network.getNodeList();
		for (CyNode node : nodes)
		{
			 View<CyNode> nodeView = networkView.getNodeView(node);
			 Paint fillColor = nodeView.getVisualProperty(BasicVisualLexicon.NODE_FILL_COLOR);
			 fillColorMap.put(fillColor, node);
			 Paint borderColor = nodeView.getVisualProperty(BasicVisualLexicon.NODE_BORDER_PAINT);
			 borderColorMap.put(borderColor, node);
		}
		System.out.println("There are " + fillColorMap.size() + " fill colors and " + borderColorMap.size() + " border colors used.");
			
		Map<Paint, CyEdge> edgeColorMap = new HashMap<Paint, CyEdge>();
		Map<LineType, CyEdge> lineTypeMap = new HashMap<LineType, CyEdge>();
		
		List<CyEdge> edges = network.getEdgeList();
		for (CyEdge edge : edges)
		{
			 View<CyEdge> edgeView = networkView.getEdgeView(edge);
			 Paint edgeColor = edgeView.getVisualProperty(BasicVisualLexicon.EDGE_PAINT);
			 edgeColorMap.put(edgeColor, edge);
			 LineType lineType = edgeView.getVisualProperty(BasicVisualLexicon.EDGE_LINE_TYPE);
			 lineTypeMap.put(lineType, edge);
		}
		System.out.println("There are " + edgeColorMap.size() + " edge colors and " + lineTypeMap.size() + " line types used.");
		
		// Now we cruise thru the list of node, then edge attributes looking for mappings.  Each mapping may potentially be a legend entry.
		VisualMappingManager manager = (VisualMappingManager) registrar.getService( VisualMappingManager.class);
		VisualStyle style = manager.getCurrentVisualStyle();
		System.out.println("style: " + style.getTitle());
		Set<VisualPropertyDependency<?>> depends = style.getAllVisualPropertyDependencies();
		for (VisualPropertyDependency<?> depend : depends)
		{
			System.out.println("Dependency: " + depend.getDisplayName());
		}
		
	}
	//------------------------------------------------------------------
	private void buildAnnotation() {
		
		// Construct the annotations to add to the diagram

		int LINE_HEIGHT = 30;
		int NLINES = 8;
		int WIDTH = 160;
		int MARGIN = 10;
		int TEXT_OFFSET_X = 80;
		int TEXT_OFFSET_Y = 20;
		int COL1WIDTH = 60;
		int BOX_HEIGHT = (NLINES * LINE_HEIGHT) + (2 * MARGIN);

		Object[] args = { "x", 0, "y", 0, "width", WIDTH, "height", BOX_HEIGHT ,  "shapeType" , "Rectangle"};
		Map<String,String> strs = ezMap(args);
		ShapeAnnotation boundingBox = shapeFactory.createAnnotation(ShapeAnnotation.class, networkView, strs);
		System.out.println("Annotation: "  + boundingBox);
//		boundingBox.setFillColor(Color.RED);
		
		if (boundingBox != null)
		{
//			boundingBox.setCanvas(Annotation.BACKGROUND);
			boundingBox.moveAnnotation(new Point2D.Double(0,0));
		}
		GroupAnnotation group = null;
			
		boolean BUILD_GROUP = false;

		if (BUILD_GROUP)
		{
			String[] groupArgs = { "x", "0", "y", "0", 
						"width", "" + WIDTH, 
						"height", "" + BOX_HEIGHT};
			group = groupFactory.createAnnotation(GroupAnnotation.class, networkView, ezMap(groupArgs));
			group.addMember(boundingBox);
		}
		else
			mgr.addAnnotation(boundingBox);
		
		Color[] colors = { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.CYAN, Color.GRAY, Color.MAGENTA, Color.YELLOW };
		String[] names= { "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel" };
		for (int i=0; i < NLINES; i++)
		{
			int yy = (i * LINE_HEIGHT) + 10;
			Object[] swatchArgs = { "x", MARGIN, "y", MARGIN + yy , "width", COL1WIDTH, "height", (LINE_HEIGHT - MARGIN),  "shapeType" , "Rectangle"};
			strs = ezMap(swatchArgs);
			ShapeAnnotation lineBox = shapeFactory.createAnnotation(ShapeAnnotation.class, networkView, strs);
			lineBox.setFillColor(colors[i]);
			lineBox.moveAnnotation(new Point2D.Double(MARGIN,yy));
			
			if (BUILD_GROUP) 		group.addMember(lineBox);
			else 					mgr.addAnnotation(lineBox);

			Object[] textArgs = { "x", TEXT_OFFSET_X, "y", TEXT_OFFSET_Y + yy, "width", WIDTH - COL1WIDTH, "height", LINE_HEIGHT, "text", names[i]};
			strs = ezMap(textArgs);
			TextAnnotation textBox = textFactory.createAnnotation(TextAnnotation.class, networkView, strs);
			textBox.moveAnnotation(new Point2D.Double(COL1WIDTH + 2 * MARGIN,yy+20));
			
			if (BUILD_GROUP) 		group.addMember(textBox);
			else 					mgr.addAnnotation(textBox);
			
		}
		if (BUILD_GROUP)				mgr.addAnnotation(group);
	}
//------------------------------------------------------------------
	
	static Map<String,String> ezMap(Object[] elems) {
	    final Map<String,String> map = new HashMap<String,String>();
	    for (int i = 0; i < elems.length-1; i += 2) 
	      map.put(elems[i].toString(), elems[i+1].toString());
	    return map;
	  }
	
}
