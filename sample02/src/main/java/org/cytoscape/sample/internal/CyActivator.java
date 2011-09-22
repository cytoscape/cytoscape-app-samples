package org.cytoscape.sample.internal;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.CyApplicationManager;

import org.cytoscape.sample.internal.MyCytoPanel;
import org.cytoscape.sample.internal.Sample02;

import org.cytoscape.application.swing.CytoPanelComponent;
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
		
		MyCytoPanel myCytoPanel = new MyCytoPanel();
		Sample02 sample02Action = new Sample02(cyApplicationManagerService,cytoscapeDesktopService,myCytoPanel);
		
		registerService(bc,myCytoPanel,CytoPanelComponent.class, new Properties());
		registerService(bc,sample02Action,CyAction.class, new Properties());

		

	}
}

