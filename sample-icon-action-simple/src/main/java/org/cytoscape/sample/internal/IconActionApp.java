package org.cytoscape.sample.internal;

import org.cytoscape.app.swing.AbstractCySwingApp;
import org.cytoscape.app.swing.CySwingAppAdapter;


/**
 * An implementation of CyPluginAdapter
 */
public class IconActionApp extends AbstractCySwingApp {
	
	public IconActionApp(CySwingAppAdapter swingAdapter){
		super(swingAdapter);
		
		swingAdapter.getCySwingApplication().addAction(new IconAction(swingAdapter.getCySwingApplication()));
	}
}
