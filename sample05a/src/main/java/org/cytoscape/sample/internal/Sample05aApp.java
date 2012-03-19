package org.cytoscape.sample.internal;

import java.util.Hashtable;
import java.util.Properties;
import org.cytoscape.app.AbstractCyApp;
import org.cytoscape.app.CyAppAdapter;
import org.cytoscape.work.TaskFactory;

/**
 * An implementation of CyPluginAdapter
 */
public class Sample05aApp extends AbstractCyApp {
	
	public Sample05aApp(CyAppAdapter a){
		super(a);
		
		Properties properties = new Properties();
		properties.put("title", "Sample5a");
		properties.put("preferredMenu", "Apps");
		properties.put("menuGravity", "12.0");

		a.getCyServiceRegistrar().registerService( new Sample05aTaskFactory(a), TaskFactory.class, properties);
	}
}
