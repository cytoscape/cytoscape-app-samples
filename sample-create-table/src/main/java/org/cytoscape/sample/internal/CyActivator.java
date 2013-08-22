package org.cytoscape.sample.internal;

import org.cytoscape.model.CyTableFactory;

import org.cytoscape.sample.internal.CreateTableTaskFactory;

import org.cytoscape.work.TaskFactory;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.edit.MapTableToNetworkTablesTaskFactory;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyTableFactory tableFactory = getService(bc,CyTableFactory.class);
		MapTableToNetworkTablesTaskFactory mapTableToNetworkTablesTaskFactory = getService(bc,MapTableToNetworkTablesTaskFactory.class);
	
		CreateTableTaskFactory createTableTaskFactory = new CreateTableTaskFactory(tableFactory,mapTableToNetworkTablesTaskFactory);
		
		Properties createTableTaskFactoryProps = new Properties();
		createTableTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		createTableTaskFactoryProps.setProperty("title","Create Table");
		registerService(bc,createTableTaskFactory,TaskFactory.class, createTableTaskFactoryProps);
	}
}

