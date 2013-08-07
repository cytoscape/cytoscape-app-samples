package org.cytoscape.sample.internal;

import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.Properties;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.application.CyApplicationManager;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyApplicationManager cyApplicationManagerServiceRef = getService(bc,CyApplicationManager.class);
		VisualMappingManager vmmServiceRef = getService(bc,VisualMappingManager.class);

		ChangeNodeBorderWidthTaskFactory changeNodeBorderWidthTaskFactory = new ChangeNodeBorderWidthTaskFactory(cyApplicationManagerServiceRef, vmmServiceRef);
				
		Properties changeNodeBorderWidthTaskFactoryProps = new Properties();
		changeNodeBorderWidthTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		changeNodeBorderWidthTaskFactoryProps.setProperty("title","Change Node Border Width");
		registerService(bc,changeNodeBorderWidthTaskFactory,TaskFactory.class, changeNodeBorderWidthTaskFactoryProps);
	}
}

