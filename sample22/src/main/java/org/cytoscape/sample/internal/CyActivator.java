package org.cytoscape.sample.internal;


import org.cytoscape.sample.internal.Sample22TaskFactory;

import org.cytoscape.work.TaskFactory;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		
		Sample22TaskFactory sample22TaskFactory = new Sample22TaskFactory();
		
		
		Properties sample22TaskFactoryProps = new Properties();
		sample22TaskFactoryProps.setProperty("preferredMenu","Plugins");
		sample22TaskFactoryProps.setProperty("menuGravity","11.0");
		sample22TaskFactoryProps.setProperty("title","Sample 22");
		registerService(bc,sample22TaskFactory,TaskFactory.class, sample22TaskFactoryProps);

		

	}
}

