package org.cytoscape.sample.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import org.cytoscape.plugin.AbstractCyPlugin;
import org.cytoscape.plugin.CyPluginAdapter;
import org.cytoscape.work.TaskFactory;

/**
 * An implementation of CyPluginAdapter
 */
public class Sample05aPlugin extends AbstractCyPlugin {
	
	public Sample05aPlugin(CyPluginAdapter a){
		super(a);
		
		Dictionary<String, String> dict = new Hashtable<String, String>();
		dict.put("title", "Sample5a");
		dict.put("preferredMenu", "Plugins");
		dict.put("menuGravity", "12.0");

		a.getCyServiceRegistrar().registerService( new Sample05aTaskFactory(a), TaskFactory.class, dict);
	}
}
