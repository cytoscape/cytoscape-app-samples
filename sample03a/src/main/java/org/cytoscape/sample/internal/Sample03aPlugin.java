package org.cytoscape.sample.internal;

import org.cytoscape.plugin.CyPlugin;
import org.cytoscape.plugin.CyPluginAdapter;


/**
 * An implementation of CyPluginAdapter
 */
public class Sample03aPlugin extends CyPlugin {
	
	public Sample03aPlugin(CyPluginAdapter a){
		super(a);
		
		a.getCySwingApplication().addAction(new Sample03aAction(a));
		
	}
}
