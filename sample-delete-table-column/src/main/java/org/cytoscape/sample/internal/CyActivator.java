package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;

import org.cytoscape.sample.internal.DeleteTableColumnTaskFactory;

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
		
		DeleteTableColumnTaskFactory deleteTableColumnTaskFactory = new DeleteTableColumnTaskFactory(cyApplicationManagerService);
		
		Properties sample12TaskFactoryProps = new Properties();
		sample12TaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		sample12TaskFactoryProps.setProperty("title","Delete Table Column");
		registerService(bc,deleteTableColumnTaskFactory,TaskFactory.class, sample12TaskFactoryProps);
	}
}

