package org.cytoscape.sample.internal;

import org.cytoscape.app.swing.AbstractCySwingApp;
import org.cytoscape.app.swing.CySwingAppAdapter;

/**
 * An implementation of CyPluginAdapter
 */
public class Sample02aApp extends AbstractCySwingApp {
	
	public Sample02aApp(CySwingAppAdapter swingAdapter){
		super(swingAdapter);
		swingAdapter.getCySwingApplication().addAction(new Sample02aAction());
	}
}
