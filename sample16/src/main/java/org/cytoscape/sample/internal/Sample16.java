package org.cytoscape.sample.internal;

import java.awt.Color;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.mappings.BoundaryRangeValues;
import org.cytoscape.view.vizmap.mappings.ContinuousMapping;


public class Sample16 extends AbstractCyAction {
	
	private VisualStyleFactory visualStyleFactoryServiceRef;
	private VisualMappingFunctionFactory continuousMappingFactoryServiceRef;
	private VisualMappingManager vmmServiceRef;
	
	public Sample16(VisualStyleFactory visualStyleFactoryServiceRef, VisualMappingFunctionFactory continuousMappingFactoryServiceRef,
			VisualMappingManager vmmServiceRef){
		// Add a menu item -- Apps->sample16
		super("sample16");
		setPreferredMenu("Apps");

		this.visualStyleFactoryServiceRef = visualStyleFactoryServiceRef;
		this.continuousMappingFactoryServiceRef	= continuousMappingFactoryServiceRef;
		this.vmmServiceRef = vmmServiceRef;
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {

		// create a new visual style
		VisualStyle vs= this.visualStyleFactoryServiceRef.createVisualStyle("sample16 visual style");

		// Set node color map to attribute "Degree"
		ContinuousMapping mapping = (ContinuousMapping)
			this.continuousMappingFactoryServiceRef.createVisualMappingFunction("Degree", Integer.class, BasicVisualLexicon.NODE_FILL_COLOR);

		// set the points
		Double val1 = 2d;
		BoundaryRangeValues<Paint> brv1 = new BoundaryRangeValues<Paint>(Color.RED, Color.GREEN, Color.PINK);

		Double val2 = 12d;
		BoundaryRangeValues<Paint> brv2 = new BoundaryRangeValues<Paint>(Color.WHITE, Color.YELLOW, Color.BLACK);
		
		mapping.addPoint(val1, brv1);
		mapping.addPoint(val2, brv2);
		
		vs.addVisualMappingFunction(mapping);	
		
		// Add the new visual style to manager
		this.vmmServiceRef.addVisualStyle(vs);
	}
}
