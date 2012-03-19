package org.cytoscape.sample.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import org.cytoscape.app.AbstractCyApp;
import org.cytoscape.app.CyAppAdapter;
import org.cytoscape.work.TaskFactory;

/**
 * An implementation of CyPluginAdapter
 */
public class Sample05aApp extends AbstractCyApp {
	
	public Sample05aApp(CyAppAdapter a){
		super(a);
		
		Dictionary<String, String> dict = new Hashtable<String, String>();
		dict.put("title", "Sample5a");
		dict.put("preferredMenu", "Apps");
		dict.put("menuGravity", "12.0");

		a.getCyServiceRegistrar().registerService( new Sample05aTaskFactory(a), TaskFactory.class, dict);
	}
}
