package org.cytoscape.sample.internal;

import java.util.Properties;
import org.cytoscape.app.AbstractCyApp;
import org.cytoscape.app.CyAppAdapter;
import org.cytoscape.work.TaskFactory;

/**
 * An implementation of CyPluginAdapter
 */
public class CreateNetworkApp extends AbstractCyApp {
	
	public CreateNetworkApp(CyAppAdapter a){
		super(a);
		
		Properties properties = new Properties();
		properties.put("title", "Create Network (simple app)");
		properties.put("preferredMenu", "Apps.Samples");

		a.getCyServiceRegistrar().registerService( new CreateNetworkTaskFactory(a), TaskFactory.class, properties);
	}
}
