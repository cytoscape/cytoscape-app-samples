package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.CyAction;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.Properties;

import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;

public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}

	public void start(BundleContext bc) {

		CyApplicationManager cyApplicationManagerServiceRef = getService(bc,CyApplicationManager.class);

		VisualMappingManager vmmServiceRef = getService(bc,VisualMappingManager.class);
		
		VisualStyleFactory visualStyleFactoryServiceRef = getService(bc,VisualStyleFactory.class);
		
		VisualMappingFunctionFactory vmfFactoryC = getService(bc,VisualMappingFunctionFactory.class, "(mapping.type=continuous)");
		VisualMappingFunctionFactory vmfFactoryD = getService(bc,VisualMappingFunctionFactory.class, "(mapping.type=discrete)");
		VisualMappingFunctionFactory vmfFactoryP = getService(bc,VisualMappingFunctionFactory.class, "(mapping.type=passthrough)");

		Sample15 sample16Action = new Sample15(cyApplicationManagerServiceRef, vmmServiceRef, visualStyleFactoryServiceRef, 
				vmfFactoryC, vmfFactoryD, vmfFactoryP);
		
		registerService(bc,sample16Action,CyAction.class, new Properties());
	}
}

