package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.sample.internal.CreateNetworkTaskFactory;
import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyNetworkManager cyNetworkManagerServiceRef = getService(bc,CyNetworkManager.class);
		CyNetworkNaming cyNetworkNamingServiceRef = getService(bc,CyNetworkNaming.class);
		CyNetworkFactory cyNetworkFactoryServiceRef = getService(bc,CyNetworkFactory.class);
		
		CreateNetworkTaskFactory createNetworkTaskFactory = new CreateNetworkTaskFactory(cyNetworkManagerServiceRef,cyNetworkNamingServiceRef,cyNetworkFactoryServiceRef);
				
		Properties sample05TaskFactoryProps = new Properties();
		sample05TaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		sample05TaskFactoryProps.setProperty("title","Create Network");
		registerService(bc,createNetworkTaskFactory,TaskFactory.class, sample05TaskFactoryProps);
	}
}

