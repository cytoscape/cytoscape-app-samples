package org.cytoscape.sample.internal;

import org.cytoscape.sample.internal.Sample09TaskFactory;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		Sample09TaskFactory sample09TaskFactory = new Sample09TaskFactory();
		
		
		Properties sample09TaskFactoryProps = new Properties();
		sample09TaskFactoryProps.setProperty("preferredMenu","Apps");
		sample09TaskFactoryProps.setProperty("menuGravity","16.0");
		sample09TaskFactoryProps.setProperty("title","Sample 9");
		registerService(bc,sample09TaskFactory,NetworkViewTaskFactory.class, sample09TaskFactoryProps);

		

	}
}

