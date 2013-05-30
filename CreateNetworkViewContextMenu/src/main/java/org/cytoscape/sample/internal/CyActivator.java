package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;
import org.cytoscape.task.NodeViewTaskFactory;
import org.cytoscape.task.EdgeViewTaskFactory;
import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyApplicationManager applicationManagerManagerServiceRef = getService(bc,CyApplicationManager.class);

		MyNetworkViewTaskFactory myNetworkViewTaskFactory = new MyNetworkViewTaskFactory(applicationManagerManagerServiceRef);
		MyNodeViewTaskFactory myNodeViewTaskFactory = new MyNodeViewTaskFactory();
		MyEdgeViewTaskFactory myEdgeViewTaskFactory = new MyEdgeViewTaskFactory();

		// Set "preferredAction" to OPEN, the task will be triggered by double-click on view
		// Set "preferredAction" to NEW, a new menu item will be added to the right click menu of the view

		// Add double click listener to the network view
		Properties myNetworkViewTaskFactoryProps = new Properties();		
		myNetworkViewTaskFactoryProps.setProperty("preferredAction","OPEN");
		myNetworkViewTaskFactoryProps.setProperty("title","my title");

		// Add double click listener to the node view
		Properties myNodeViewTaskFactoryProps = new Properties();		
		myNodeViewTaskFactoryProps.setProperty("preferredAction","OPEN");
		myNodeViewTaskFactoryProps.setProperty("title","my node action");

		// Add right click menu item to the edge view
		Properties myEdgeViewTaskFactoryProps = new Properties();		
		myEdgeViewTaskFactoryProps.setProperty("preferredAction","NEW");
		myEdgeViewTaskFactoryProps.setProperty("title","my edge action");

		// Register services
		registerService(bc,myNetworkViewTaskFactory,NetworkViewTaskFactory.class, myNetworkViewTaskFactoryProps);
		registerService(bc,myNodeViewTaskFactory,NodeViewTaskFactory.class, myNodeViewTaskFactoryProps);
		registerService(bc,myEdgeViewTaskFactory,EdgeViewTaskFactory.class, myEdgeViewTaskFactoryProps);
	}
}

