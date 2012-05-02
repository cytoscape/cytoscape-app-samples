package org.cytoscape.sample.internal;

import org.cytoscape.app.swing.AbstractCySwingApp;
import org.cytoscape.app.swing.CySwingAppAdapter;


/**
 * An implementation of CyPluginAdapter
 */
public class Sample03aApp extends AbstractCySwingApp {
	
	public Sample03aApp(CySwingAppAdapter swingAdapter){
		super(swingAdapter);
		
		swingAdapter.getCySwingApplication().addAction(new Sample03aAction());
	}
}
