package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.view.vizmap.VisualMappingFunction;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;

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

		VisualStyle vs= this.visualStyleFactoryServiceRef.createVisualStyle("sample16 visual style");
		this.vmmServiceRef.addVisualStyle(vs);

		System.out.println("New visual style is created!");

		VisualMappingFunction mapping = 
			this.continuousMappingFactoryServiceRef.createVisualMappingFunction("degree", Integer.class, null, BasicVisualLexicon.NODE_FILL_COLOR);

		
		//mapping.
		
		vs.addVisualMappingFunction(mapping);	
	}
}
