package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;

import org.cytoscape.sample.internal.Sample09TaskFactory;

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
		
		Sample09TaskFactory sample09TaskFactory = new Sample09TaskFactory(cyApplicationManagerService);
		
		
		Properties sample09TaskFactoryProps = new Properties();
		sample09TaskFactoryProps.setProperty("preferredMenu","Plugins");
		sample09TaskFactoryProps.setProperty("menuGravity","16.0");
		sample09TaskFactoryProps.setProperty("title","Sample 9");
		registerService(bc,sample09TaskFactory,TaskFactory.class, sample09TaskFactoryProps);

		

	}
}

