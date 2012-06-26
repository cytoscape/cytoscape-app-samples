package org.cytoscape.sample.sample26.internal;

import java.util.Properties;

import org.cytoscape.application.swing.CyEdgeViewContextMenuFactory;
import org.cytoscape.application.swing.CyNodeViewContextMenuFactory;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		CyNodeViewContextMenuFactory cyNodeVCMF  = new CyNodeVCMFSample();
		CyEdgeViewContextMenuFactory cyEdgeVCMF = new CyEdgeVCNMFSample();
		
		Properties properties = new Properties();
		registerAllServices(context, cyNodeVCMF, properties);
		registerAllServices(context, cyEdgeVCMF, properties);
		
	}

}
