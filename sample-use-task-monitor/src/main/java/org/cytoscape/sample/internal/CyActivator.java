package org.cytoscape.sample.internal;


import org.cytoscape.sample.internal.UseTaskMonitorTaskFactory;

import org.cytoscape.work.TaskFactory;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		UseTaskMonitorTaskFactory useTaskMonitorTaskFactory = new UseTaskMonitorTaskFactory();
		
		Properties useTaskMonitorTaskFactoryProps = new Properties();
		useTaskMonitorTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		useTaskMonitorTaskFactoryProps.setProperty("title","Use Task Monitor");
		registerService(bc,useTaskMonitorTaskFactory,TaskFactory.class, useTaskMonitorTaskFactoryProps);
	}
}

