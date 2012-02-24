package org.cytoscape.sample.internal;


import org.cytoscape.sample.internal.Sample16;
import org.cytoscape.application.swing.CyAction;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		Sample16 sample16Action = new Sample16();
		
		registerService(bc,sample16Action,CyAction.class, new Properties());

		

	}
}

