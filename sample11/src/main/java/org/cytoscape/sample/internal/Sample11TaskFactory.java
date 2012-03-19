package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyTableFactory;
import org.cytoscape.model.subnetwork.CyRootNetworkManager;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample11TaskFactory implements TaskFactory {
	
	private CyTableFactory tableFactory;
	private CyApplicationManager appMgr;
	private CyNetworkManager netMgr;
	private CyRootNetworkManager rootNetworkManager;
	
	public Sample11TaskFactory(CyApplicationManager appMgr, 
			CyNetworkManager netMgr, CyTableFactory tableFactory,
			CyRootNetworkManager rootNetworkManager){
		
		this.appMgr = appMgr;
		this.netMgr = netMgr;
		this.tableFactory = tableFactory;
		this.rootNetworkManager = rootNetworkManager;
	}
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new CreateTableTask(appMgr, netMgr, tableFactory, rootNetworkManager));
	}

}
