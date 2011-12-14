package org.cytoscape.sample.internal;

import org.cytoscape.plugin.CyPluginAdapter;
import org.cytoscape.plugin.AbstractCyPlugin;

/**
 * An implementation of CyPluginAdapter
 */
public class Sample02aPlugin extends AbstractCyPlugin {
	
	public Sample02aPlugin(CyPluginAdapter a){
		super(a);
		
		a.getCySwingApplication().addAction(new Sample02aAction());
		
	}
}
