package org.cytoscape.sample.internal;

import org.cytoscape.application.swing.CySwingApplication;

import org.cytoscape.sample.internal.Sample04;

import org.cytoscape.application.swing.CyAction;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		CySwingApplication cytoscapeDesktopService = getService(bc,CySwingApplication.class);
		Sample04 Sample04Action = new Sample04(cytoscapeDesktopService);
		registerService(bc,Sample04Action,CyAction.class, new Properties());
	}
}

