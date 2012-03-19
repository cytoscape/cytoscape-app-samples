package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.model.CyTable;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.presentation.property.NodeShapeVisualProperty;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.view.vizmap.VisualMappingFunction;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.mappings.DiscreteMapping;
import org.cytoscape.view.vizmap.mappings.PassthroughMapping;
import java.util.Iterator;


public class Sample15 extends AbstractCyAction {

	private CyApplicationManager cyApplicationManagerServiceRef;
	private VisualStyleFactory visualStyleFactoryServiceRef;
	private VisualMappingManager vmmServiceRef;
	
	private VisualMappingFunctionFactory vmfFactoryC;
	private VisualMappingFunctionFactory vmfFactoryD;
	private VisualMappingFunctionFactory vmfFactoryP;
	
	public Sample15(CyApplicationManager cyApplicationManagerServiceRef, VisualMappingManager vmmServiceRef, VisualStyleFactory visualStyleFactoryServiceRef, 
			VisualMappingFunctionFactory vmfFactoryC,VisualMappingFunctionFactory vmfFactoryD,VisualMappingFunctionFactory vmfFactoryP){
		// Add a menu item -- Apps->sample15
		super("sample15");
		setPreferredMenu("Apps");

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
			if (curVS.getTitle().equalsIgnoreCase("sample15 visual style"))
			{
				vmmServiceRef.removeVisualStyle(curVS);
				break;
			}
		}
		
		// Create a new Visual style
		VisualStyle vs= this.visualStyleFactoryServiceRef.createVisualStyle("sample15 visual style");
		this.vmmServiceRef.addVisualStyle(vs);

		CyTable attrForTest = cyApplicationManagerServiceRef.getCurrentNetwork().getDefaultNodeTable();

		// 1. pass-through mapping
		String ctrAttrName1 = "SUID";
		PassthroughMapping pMapping = (PassthroughMapping) this.vmfFactoryP.createVisualMappingFunction(ctrAttrName1, String.class, attrForTest, BasicVisualLexicon.NODE_LABEL);
		
		// 2. DiscreteMapping - Set node shape based on attribute value
		String ctrAttrName2 = "NodeShape";
		Class dataType = String.class; 

		DiscreteMapping dMapping = (DiscreteMapping) this.vmfFactoryD.createVisualMappingFunction(ctrAttrName2, dataType, attrForTest, BasicVisualLexicon.NODE_SHAPE);

		// If attribute value is "diamon", map the nodeShape to DIAMOND
		String key  = "diamond";
		dMapping.putMapValue(key, NodeShapeVisualProperty.DIAMOND);

		// If attribute value is "triangle", map the nodeShape to TRIANGLE
		key  = "triangle";
		dMapping.putMapValue(key, NodeShapeVisualProperty.TRIANGLE);

		//3. continous mapping. Please look at Sample16
		
		vs.addVisualMappingFunction(pMapping);			
		vs.addVisualMappingFunction(dMapping);			
	}
}
