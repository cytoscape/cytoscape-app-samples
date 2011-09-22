package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;

import org.cytoscape.sample.internal.Sample10TaskFactory;

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
		
		Sample10TaskFactory sample10TaskFactory = new Sample10TaskFactory(cyApplicationManagerService);
		
		
		Properties sample10TaskFactoryProps = new Properties();
		sample10TaskFactoryProps.setProperty("preferredMenu","Plugins");
		sample10TaskFactoryProps.setProperty("menuGravity","11.0");
		sample10TaskFactoryProps.setProperty("title","Sample 10");
		registerService(bc,sample10TaskFactory,TaskFactory.class, sample10TaskFactoryProps);

		

	}
}

