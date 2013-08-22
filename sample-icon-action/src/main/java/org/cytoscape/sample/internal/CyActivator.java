package org.cytoscape.sample.internal;

import java.util.Properties;

import org.cytoscape.application.swing.CyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;



public class CyActivator extends AbstractCyActivator {

	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		CySwingApplication cytoscapeDesktopService = getService(bc,CySwingApplication.class);
		IconAction iconAction = new IconAction(cytoscapeDesktopService);
		registerService(bc,iconAction,CyAction.class, new Properties());
	}
}

