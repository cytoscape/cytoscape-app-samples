package org.cytoscape.sample.internal;


import org.cytoscape.sample.internal.Sample08;

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

		
		Sample08 sample08 = new Sample08();
		
		registerService(bc,sample08,AddedNodesListener.class, new Properties());
		registerService(bc,sample08,NetworkAddedListener.class, new Properties());
		registerService(bc,sample08,NetworkAboutToBeDestroyedListener.class, new Properties());
		registerService(bc,sample08,NetworkViewAddedListener.class, new Properties());

		

	}
}

