package org.cytoscape.sample.internal;

import java.util.Properties;

import org.cytoscape.application.swing.CyEdgeViewContextMenuFactory;
import org.cytoscape.application.swing.CyNodeViewContextMenuFactory;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		CyNodeViewContextMenuFactory myNodeViewContextMenuFactory  = new MyNodeViewContextMenuFactory();
		Properties myNodeViewContextMenuFactoryProps = new Properties();
		myNodeViewContextMenuFactoryProps.put("preferredMenu", "Apps.Samples");
		registerAllServices(context, myNodeViewContextMenuFactory, myNodeViewContextMenuFactoryProps);
		
		CyEdgeViewContextMenuFactory myEdgeViewContextMenuFactory = new MyEdgeViewContextMenuFactory();
		Properties myEdgeViewContextMenuFactoryProps = new Properties();
		myEdgeViewContextMenuFactoryProps.put("preferredMenu", "Apps.Samples");
		registerAllServices(context, myEdgeViewContextMenuFactory, myEdgeViewContextMenuFactoryProps);
	}

}
