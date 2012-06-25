package org.cytoscape.sample.sample24.internal;

import java.util.Properties;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.CyHelpBroker;
import org.cytoscape.event.CyEventHelper;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		
		CyApplicationManager cyApplicationManager = getService(context, CyApplicationManager.class);
		CyHelpBroker cyHelpBroker = getService(context, CyHelpBroker.class);

		MenuAction action = new MenuAction(cyHelpBroker);
		
		Properties properties = new Properties();
		
		registerAllServices(context, action, properties);
	}

}
