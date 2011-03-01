package org.cytoscape.sample.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import org.cytoscape.plugin.CyPlugin;
import org.cytoscape.plugin.CyPluginAdapter;


/**
 * An implementation of CyPluginAdapter
 */
public class Sample05aPlugin extends CyPlugin {
	
	public Sample05aPlugin(CyPluginAdapter a){
		super(a);
		
		Dictionary<String, String> dict = new Hashtable<String, String>();
		dict.put("title", "Sample5a");
		dict.put("preferredMenu", "Plugins");
		dict.put("menuGravity", "10.0");

		a.getCyServiceRegistrar().registerService( new Sample05aTaskFactory(a), Sample05aTaskFactory.class, dict);
	}
}
