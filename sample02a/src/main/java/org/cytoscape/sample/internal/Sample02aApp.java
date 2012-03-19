package org.cytoscape.sample.internal;

import org.cytoscape.app.AbstractCyApp;
import org.cytoscape.app.CyAppAdapter;

/**
 * An implementation of CyPluginAdapter
 */
public class Sample02aApp extends AbstractCyApp {
	
	public Sample02aApp(CyAppAdapter adapter){
		super(adapter);
		adapter.getCySwingApplication().addAction(new Sample02aAction());
	}
}
