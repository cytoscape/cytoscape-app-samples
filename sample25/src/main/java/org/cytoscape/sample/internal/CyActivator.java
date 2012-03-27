package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;
import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyApplicationManager applicationManagerManagerServiceRef = getService(bc,CyApplicationManager.class);

		MyNetworkViewTaskFactory sample25TaskFactory = new MyNetworkViewTaskFactory(applicationManagerManagerServiceRef);
		
		Properties sample25TaskFactoryProps = new Properties();
		
		// If "preferredAction" is OPEN, the task will be triggered by double-click on network view
		sample25TaskFactoryProps.setProperty("preferredAction","OPEN");

		// If "preferredAction" is NEW, a new menu item will be added to the right click menu of the network view
		//sample25TaskFactoryProps.setProperty("preferredAction","NEW");

		registerService(bc,sample25TaskFactory,NetworkViewTaskFactory.class, sample25TaskFactoryProps);
	}
}

