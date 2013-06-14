package org.cytoscape.sample.internal;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.sample.internal.MyNestedNetworkAction;
import org.cytoscape.application.swing.CyAction;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.Properties;
import org.cytoscape.app.swing.CySwingAppAdapter;;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		//CySwingApplication cytoscapeDesktopService = getService(bc,CySwingApplication.class);
		
		CySwingAppAdapter adapter = getService(bc,CySwingAppAdapter.class);
		
//		MyCytoPanel myCytoPanel = new MyCytoPanel();
		MyNestedNetworkAction nestedNetworkAction = new MyNestedNetworkAction(adapter);
		
//		registerService(bc,myCytoPanel,CytoPanelComponent.class, new Properties());
		registerService(bc,nestedNetworkAction,CyAction.class, new Properties());

	}
}

