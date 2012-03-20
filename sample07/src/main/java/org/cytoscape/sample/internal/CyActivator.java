package org.cytoscape.sample.internal;

import org.cytoscape.sample.internal.Sample07TaskFactory;

import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkTaskFactory;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		Sample07TaskFactory sample07TaskFactory = new Sample07TaskFactory();
		
		
		Properties sample07TaskFactoryProps = new Properties();
		sample07TaskFactoryProps.setProperty("preferredMenu","Apps");
		sample07TaskFactoryProps.setProperty("menuGravity","11.0");
		sample07TaskFactoryProps.setProperty("title","Sample 7");
		registerService(bc,sample07TaskFactory,NetworkTaskFactory.class, sample07TaskFactoryProps);

		

	}
}

