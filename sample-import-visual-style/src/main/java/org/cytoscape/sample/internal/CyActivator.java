package org.cytoscape.sample.internal;

import org.osgi.framework.BundleContext;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.read.LoadVizmapFileTaskFactory;
import org.cytoscape.task.visualize.ApplyVisualStyleTaskFactory;
import org.cytoscape.work.TaskFactory;
import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyApplicationManager cyApplicationManagerServiceRef = getService(bc,CyApplicationManager.class);
		LoadVizmapFileTaskFactory loadVizmapFileTaskFactory =  getService(bc,LoadVizmapFileTaskFactory.class);
		ApplyVisualStyleTaskFactory applyVisualStyleTaskFactory = getService(bc,ApplyVisualStyleTaskFactory.class);
		
		ImportVisualStyleTaskFactory importVisualStyleTaskFactory= new ImportVisualStyleTaskFactory(loadVizmapFileTaskFactory,
				cyApplicationManagerServiceRef, applyVisualStyleTaskFactory);
		
		Properties importVisualStyleTaskFactoryProps = new Properties();
		importVisualStyleTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		importVisualStyleTaskFactoryProps.setProperty("title","Import Visual Style");
		registerService(bc,importVisualStyleTaskFactory,TaskFactory.class, importVisualStyleTaskFactoryProps);
	}
}

