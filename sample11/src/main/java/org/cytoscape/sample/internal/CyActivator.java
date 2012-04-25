package org.cytoscape.sample.internal;

import org.cytoscape.model.CyTableFactory;

import org.cytoscape.sample.internal.Sample11TaskFactory;

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

		CyTableFactory cyDataTableFactoryServiceRef = getService(bc,CyTableFactory.class);
		MapTableToNetworkTablesTaskFactory mapNetworkAttrTFServiceRef = getService(bc,MapTableToNetworkTablesTaskFactory.class);
	
		
		Sample11TaskFactory sample11TaskFactory = new Sample11TaskFactory(cyDataTableFactoryServiceRef,mapNetworkAttrTFServiceRef);
		
		
		Properties sample11TaskFactoryProps = new Properties();
		sample11TaskFactoryProps.setProperty("preferredMenu","Apps");
		sample11TaskFactoryProps.setProperty("menuGravity","12.0");
		sample11TaskFactoryProps.setProperty("title","Sample 11");
		registerService(bc,sample11TaskFactory,TaskFactory.class, sample11TaskFactoryProps);

		

	}
}

