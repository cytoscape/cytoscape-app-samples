package org.cytoscape.sample.internal;

import org.cytoscape.plugin.CyPluginAdapter;
import org.cytoscape.plugin.CyPlugin;

/**
 * An implementation of CyPluginAdapter
 */
public class Sample02aPlugin extends CyPlugin {
	
	public Sample02aPlugin(CyPluginAdapter a){
		super(a);
		
		a.getCySwingApplication().addAction(new Sample02aAction(a));
		
	}
}
