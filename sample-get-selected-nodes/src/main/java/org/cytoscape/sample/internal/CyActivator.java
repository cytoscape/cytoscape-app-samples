package org.cytoscape.sample.internal;

import java.util.Properties;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.CyAction;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		CyApplicationManager cyApplicationManager = getService(bc, CyApplicationManager.class);
		GetSelectedNodesAction getSelectedNodesAction = new GetSelectedNodesAction(cyApplicationManager);
		registerService(bc,getSelectedNodesAction,CyAction.class,new Properties());
	}
}

