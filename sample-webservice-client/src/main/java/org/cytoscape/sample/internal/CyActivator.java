
package org.cytoscape.sample.internal;

import java.util.Properties;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.sample.internal.MyWebServiceClient;
import org.cytoscape.sample.internal.MyWebServiceClientPanel;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyTableFactory;
import org.cytoscape.model.CyTableManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.edit.MapTableToNetworkTablesTaskFactory;
import org.cytoscape.work.swing.DialogTaskManager;
import org.osgi.framework.BundleContext;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}

	public void start(BundleContext bc) {

		// Import services
		CySwingApplication cySwingApplicationServiceRef = getService(bc,CySwingApplication.class);
		DialogTaskManager taskManagerServiceRef = getService(bc,DialogTaskManager.class);
		CyNetworkManager cyNetworkManagerServiceRef = getService(bc,CyNetworkManager.class);
		CyTableManager cyTableManagerServiceRef = getService(bc,CyTableManager.class);
		CyApplicationManager cyApplicationManagerServiceRef = getService(bc,CyApplicationManager.class);
		CyTableFactory cyTableFactoryServiceRef = getService(bc,CyTableFactory.class);
		MapTableToNetworkTablesTaskFactory mapNetworkAttrTFServiceRef = getService(bc,MapTableToNetworkTablesTaskFactory.class);
		
		
		// Export services
		MyWebServiceClientPanel myPanel = new MyWebServiceClientPanel(taskManagerServiceRef,cyApplicationManagerServiceRef,cyTableManagerServiceRef,cyNetworkManagerServiceRef);
		
		MyWebServiceClient myClient = new MyWebServiceClient("My Web Service Client","My Test Web Service Client.",cyTableFactoryServiceRef,cySwingApplicationServiceRef,cyTableManagerServiceRef, myPanel, mapNetworkAttrTFServiceRef);
		myPanel.setClient(myClient);
		
		registerAllServices(bc,myPanel, new Properties());
		registerAllServices(bc,myClient, new Properties());
	}
}

