package org.cytoscape.sample.internal;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.CyApplicationManager;

import org.cytoscape.sample.internal.AddImageIconAction;

import org.cytoscape.application.swing.CyAction;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyApplicationManager cyApplicationManagerService = getService(bc,CyApplicationManager.class);
		CySwingApplication cytoscapeDesktopService = getService(bc,CySwingApplication.class);
		
		AddImageIconAction addImageIconAction = new AddImageIconAction(cyApplicationManagerService,cytoscapeDesktopService);
		
				registerService(bc,addImageIconAction,CyAction.class, new Properties());

		

	}
}

