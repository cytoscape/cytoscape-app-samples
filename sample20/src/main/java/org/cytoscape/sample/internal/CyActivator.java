package org.cytoscape.sample.internal;


import org.cytoscape.sample.internal.MyNodeViewTaskFactory;

import org.cytoscape.task.NodeViewTaskFactory;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		
		MyNodeViewTaskFactory myNodeViewTaskFactory = new MyNodeViewTaskFactory();
		
		
		Properties myNodeViewTaskFactoryProps = new Properties();
		myNodeViewTaskFactoryProps.setProperty("title","Double node size");
		registerService(bc,myNodeViewTaskFactory,NodeViewTaskFactory.class, myNodeViewTaskFactoryProps);

		

	}
}

