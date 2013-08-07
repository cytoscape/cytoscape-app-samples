package org.cytoscape.sample.internal;

import java.util.Properties;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.EdgeViewTaskFactory;
import org.cytoscape.task.NetworkViewTaskFactory;
import org.cytoscape.task.NodeViewTaskFactory;
import org.osgi.framework.BundleContext;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		MyNetworkViewTaskFactory myNetworkViewTaskFactory = new MyNetworkViewTaskFactory();
		MyNodeViewTaskFactory myNodeViewTaskFactory = new MyNodeViewTaskFactory();
		MyEdgeViewTaskFactory myEdgeViewTaskFactory = new MyEdgeViewTaskFactory();

		// Set "preferredAction" to OPEN, the task will be triggered by double-click on view
		// Set "preferredAction" to NEW, a new menu item will be added to the right click menu of the view

		// Add double click listener to the network view
		Properties myNetworkViewTaskFactoryProps = new Properties();		
		myNetworkViewTaskFactoryProps.setProperty("preferredAction","OPEN");
		myNetworkViewTaskFactoryProps.setProperty("title","Network View Task");

		// Add right click listener to the node view
		Properties myNodeViewTaskFactoryProps = new Properties();		
		myNodeViewTaskFactoryProps.setProperty("preferredAction","NEW");
		myNodeViewTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		myNodeViewTaskFactoryProps.setProperty("title","Node View Task");

		// Add right click menu item to the edge view
		Properties myEdgeViewTaskFactoryProps = new Properties();		
		myEdgeViewTaskFactoryProps.setProperty("preferredAction","NEW");
		myEdgeViewTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		myEdgeViewTaskFactoryProps.setProperty("title","Edge View Task");

		// Register services
		registerService(bc,myNetworkViewTaskFactory,NetworkViewTaskFactory.class, myNetworkViewTaskFactoryProps);
		registerService(bc,myNodeViewTaskFactory,NodeViewTaskFactory.class, myNodeViewTaskFactoryProps);
		registerService(bc,myEdgeViewTaskFactory,EdgeViewTaskFactory.class, myEdgeViewTaskFactoryProps);
	}
}

