package org.cytoscape.sample.internal;

import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.work.TaskFactory;
import java.util.Properties;
import org.cytoscape.io.webservice.WebServiceClient;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		WebServiceHelper wsh = new WebServiceHelper();		
		
		UseWebServiceTaskFactory lvp= new UseWebServiceTaskFactory(wsh);
		
		Properties sample13Props = new Properties();
		sample13Props.setProperty("preferredMenu","Apps");
		sample13Props.setProperty("menuGravity","11.6");
		sample13Props.setProperty("title","Sample 13-- use webservice");
		registerService(bc,lvp,TaskFactory.class, sample13Props);

		registerServiceListener(bc,wsh,"addWebServiceClient","removeWebServiceClient",WebServiceClient.class);
	}
}

