package org.cytoscape.sample.internal;

import java.util.Properties;

import org.cytoscape.app.swing.CySwingAppAdapter;
import org.cytoscape.application.swing.CyAction;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		CySwingAppAdapter adapter = getService(bc,CySwingAppAdapter.class);
		CreateNestedNetworkAction createNestedNetworkAction = new CreateNestedNetworkAction(adapter);
		registerService(bc,createNestedNetworkAction,CyAction.class, new Properties());
	}
}

