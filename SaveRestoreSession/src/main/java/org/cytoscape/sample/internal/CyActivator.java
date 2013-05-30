package org.cytoscape.sample.internal;


import org.cytoscape.sample.internal.Sample21;

import org.cytoscape.session.events.SessionAboutToBeSavedListener;
import org.cytoscape.session.events.SessionLoadedListener;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		
		Sample21 sample21 = new Sample21();
		
				registerService(bc,sample21,SessionAboutToBeSavedListener.class, new Properties());
		registerService(bc,sample21,SessionLoadedListener.class, new Properties());

		

	}
}

