package org.cytoscape.sample.internal;

import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.view.model.CyNetworkViewFactory;

import org.cytoscape.sample.internal.Sample06TaskFactory;

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
		CyNetworkViewFactory cyNetworkViewFactoryServiceRef = getService(bc,CyNetworkViewFactory.class);
		CyNetworkViewManager cyNetworkViewManagerServiceRef = getService(bc,CyNetworkViewManager.class);
		
		Sample06TaskFactory sample06TaskFactory = new Sample06TaskFactory(cyApplicationManagerService,cyNetworkViewFactoryServiceRef,cyNetworkViewManagerServiceRef);
		
		
		Properties sample06TaskFactoryProps = new Properties();
		sample06TaskFactoryProps.setProperty("preferredMenu","Apps");
		sample06TaskFactoryProps.setProperty("menuGravity","12.0");
		sample06TaskFactoryProps.setProperty("title","Sample 6");
		registerService(bc,sample06TaskFactory,TaskFactory.class, sample06TaskFactoryProps);

		

	}
}

