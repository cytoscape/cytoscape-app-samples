package org.cytoscape.sample.internal;

import org.cytoscape.sample.internal.ZoomNetworkViewTaskFactory;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		ZoomNetworkViewTaskFactory zoomNetworkViewTaskFactory = new ZoomNetworkViewTaskFactory();
		Properties zoomNetworkViewTaskFactoryProps = new Properties();
		zoomNetworkViewTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		zoomNetworkViewTaskFactoryProps.setProperty("title","Zoom Network View");
		registerService(bc,zoomNetworkViewTaskFactory,NetworkViewTaskFactory.class, zoomNetworkViewTaskFactoryProps);
	}
}

