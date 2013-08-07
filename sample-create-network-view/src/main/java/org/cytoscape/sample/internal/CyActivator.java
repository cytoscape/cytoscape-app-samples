package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.session.CyNetworkNaming;

import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyNetworkNaming cyNetworkNamingServiceRef = getService(bc,CyNetworkNaming.class);
		
		CyNetworkFactory cyNetworkFactoryServiceRef = getService(bc,CyNetworkFactory.class);
		CyNetworkManager cyNetworkManagerServiceRef = getService(bc,CyNetworkManager.class);

		CyNetworkViewFactory cyNetworkViewFactoryServiceRef = getService(bc,CyNetworkViewFactory.class);
		CyNetworkViewManager cyNetworkViewManagerServiceRef = getService(bc,CyNetworkViewManager.class);
		
		CreateNetworkViewTaskFactory createNetworkViewTaskFactory = new CreateNetworkViewTaskFactory(cyNetworkNamingServiceRef, cyNetworkFactoryServiceRef,cyNetworkManagerServiceRef, cyNetworkViewFactoryServiceRef,cyNetworkViewManagerServiceRef);
				
		Properties createNetworkViewTaskFactoryProps = new Properties();
		createNetworkViewTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		createNetworkViewTaskFactoryProps.setProperty("title","Create Network View");
		registerService(bc,createNetworkViewTaskFactory,TaskFactory.class, createNetworkViewTaskFactoryProps);
	}
}

