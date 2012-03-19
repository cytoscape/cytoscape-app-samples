package org.cytoscape.sample.internal;

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

		VisualStyleFactory visualStyleFactoryServiceRef = getService(bc,VisualStyleFactory.class);
		
		VisualMappingFunctionFactory continuousMappingFactoryServiceRef = getService(bc,VisualMappingFunctionFactory.class,"(mapping.type=continuous)");

		VisualMappingManager vmmServiceRef = getService(bc,VisualMappingManager.class);
		
		Sample16 sample16Action = new Sample16(visualStyleFactoryServiceRef, continuousMappingFactoryServiceRef, vmmServiceRef);
		
		registerService(bc,sample16Action,CyAction.class, new Properties());
	}
}

