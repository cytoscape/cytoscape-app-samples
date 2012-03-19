package org.cytoscape.sample.internal;

import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.creation.LoadVisualStyles;
import org.cytoscape.work.TaskFactory;
import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		LoadVisualStyles loadVizmapFileTaskFactory =  getService(bc,LoadVisualStyles.class);
		
		LoadVisualPropertiesTaskFactory lvp= new LoadVisualPropertiesTaskFactory(loadVizmapFileTaskFactory);
		
		Properties sample17Props = new Properties();
		sample17Props.setProperty("preferredMenu","Apps");
		sample17Props.setProperty("menuGravity","11.5");
		sample17Props.setProperty("title","Sample 17");
		registerService(bc,lvp,TaskFactory.class, sample17Props);
	}
}

