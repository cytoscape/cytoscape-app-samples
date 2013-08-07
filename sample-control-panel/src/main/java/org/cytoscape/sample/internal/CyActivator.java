package org.cytoscape.sample.internal;

import org.cytoscape.application.swing.CySwingApplication;

import org.cytoscape.sample.internal.MyControlPanel;
import org.cytoscape.sample.internal.ControlPanelAction;

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
		CySwingApplication cytoscapeDesktopService = getService(bc,CySwingApplication.class);
		
		MyControlPanel myControlPanel = new MyControlPanel();
		ControlPanelAction controlPanelAction = new ControlPanelAction(cytoscapeDesktopService,myControlPanel);
		
		registerService(bc,myControlPanel,CytoPanelComponent.class, new Properties());
		registerService(bc,controlPanelAction,CyAction.class, new Properties());
	}
}

