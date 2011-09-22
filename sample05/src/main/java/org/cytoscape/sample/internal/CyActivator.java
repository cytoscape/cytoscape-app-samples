package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.model.CyNetworkManager;

import org.cytoscape.sample.internal.Sample05TaskFactory;

import org.cytoscape.work.TaskFactory;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyApplicationManager cyApplicationManagerService = getService(bc,CyApplicationManager.class);
		CyNetworkManager cyNetworkManagerServiceRef = getService(bc,CyNetworkManager.class);
		CyNetworkNaming cyNetworkNamingServiceRef = getService(bc,CyNetworkNaming.class);
		CyNetworkFactory cyNetworkFactoryServiceRef = getService(bc,CyNetworkFactory.class);
		
		Sample05TaskFactory sample05TaskFactory = new Sample05TaskFactory(cyApplicationManagerService,cyNetworkManagerServiceRef,cyNetworkNamingServiceRef,cyNetworkFactoryServiceRef);
		
		
		Properties sample05TaskFactoryProps = new Properties();
		sample05TaskFactoryProps.setProperty("preferredMenu","Plugins");
		sample05TaskFactoryProps.setProperty("menuGravity","11.0");
		sample05TaskFactoryProps.setProperty("title","Sample 5");
		registerService(bc,sample05TaskFactory,TaskFactory.class, sample05TaskFactoryProps);

		

	}
}

