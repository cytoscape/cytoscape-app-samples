package org.cytoscape.sample.internal;

import org.cytoscape.sample.internal.SetNetworkBackgroundColorTaskFactory;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		SetNetworkBackgroundColorTaskFactory setNetworkBackgroundColorTaskFactory = new SetNetworkBackgroundColorTaskFactory();
		
		Properties setNetworkBackgroundColorTaskFactoryProps = new Properties();
		setNetworkBackgroundColorTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		setNetworkBackgroundColorTaskFactoryProps.setProperty("title","Set Network Background Color");
		registerService(bc,setNetworkBackgroundColorTaskFactory,NetworkViewTaskFactory.class, setNetworkBackgroundColorTaskFactoryProps);
	}
}

