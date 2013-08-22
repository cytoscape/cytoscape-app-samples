package org.cytoscape.sample.internal;


import org.cytoscape.sample.internal.SaveRestoreStateFile;

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
		SaveRestoreStateFile saveRestoreStateFile = new SaveRestoreStateFile();
		
		registerService(bc,saveRestoreStateFile,SessionAboutToBeSavedListener.class, new Properties());
		registerService(bc,saveRestoreStateFile,SessionLoadedListener.class, new Properties());
	}
}

