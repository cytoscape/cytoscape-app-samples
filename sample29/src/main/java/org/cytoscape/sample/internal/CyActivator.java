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

		Sample29TaskFactory sample05TaskFactory = new Sample29TaskFactory(cyApplicationManagerServiceRef, vmmServiceRef);
				
		Properties sample29TaskFactoryProps = new Properties();
		sample29TaskFactoryProps.setProperty("preferredMenu","Apps");
		sample29TaskFactoryProps.setProperty("menuGravity","18.0");
		sample29TaskFactoryProps.setProperty("title","Sample 29");
		registerService(bc,sample05TaskFactory,TaskFactory.class, sample29TaskFactoryProps);
	}
}

