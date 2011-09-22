package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;

import org.cytoscape.sample.internal.Sample12TaskFactory;

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
		
		Sample12TaskFactory sample12TaskFactory = new Sample12TaskFactory(cyApplicationManagerService);
		
		
		Properties sample12TaskFactoryProps = new Properties();
		sample12TaskFactoryProps.setProperty("preferredMenu","Plugins");
		sample12TaskFactoryProps.setProperty("menuGravity","10.0");
		sample12TaskFactoryProps.setProperty("title","Sample 12");
		registerService(bc,sample12TaskFactory,TaskFactory.class, sample12TaskFactoryProps);

		

	}
}

