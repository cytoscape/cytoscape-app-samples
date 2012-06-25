package org.cytoscape.sample.sample24.internal;

import java.util.Properties;

import org.cytoscape.application.swing.CyHelpBroker;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		
		CyHelpBroker cyHelpBroker = getService(context, CyHelpBroker.class);

		AppHelp action = new AppHelp(cyHelpBroker);
		registerAllServices(context, action, new Properties());
	}

}
