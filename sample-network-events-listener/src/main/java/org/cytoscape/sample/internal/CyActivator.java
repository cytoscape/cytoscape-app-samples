package org.cytoscape.sample.internal;


import org.cytoscape.sample.internal.NetworkEventsListener;

import org.cytoscape.model.events.NetworkAddedListener;
import org.cytoscape.view.model.events.NetworkViewAddedListener;
import org.cytoscape.model.events.AddedNodesListener;
import org.cytoscape.model.events.NetworkAboutToBeDestroyedListener;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		NetworkEventsListener networkEventsListener = new NetworkEventsListener();
		
		registerService(bc,networkEventsListener,AddedNodesListener.class, new Properties());
		registerService(bc,networkEventsListener,NetworkAddedListener.class, new Properties());
		registerService(bc,networkEventsListener,NetworkAboutToBeDestroyedListener.class, new Properties());
		registerService(bc,networkEventsListener,NetworkViewAddedListener.class, new Properties());
	}
}

