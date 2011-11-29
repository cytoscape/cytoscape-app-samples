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
	private CyRootNetworkManager rootNetworkFactory;
	
	public Sample11TaskFactory(CyApplicationManager appMgr, 
			CyNetworkManager netMgr, CyTableFactory tableFactory,
			CyRootNetworkManager rootNetworkFactory){
		
		this.appMgr = appMgr;
		this.netMgr = netMgr;
		this.tableFactory = tableFactory;
		this.rootNetworkFactory = rootNetworkFactory;
	}
	public TaskIterator getTaskIterator() {
		return new TaskIterator(new CreateTableTask(appMgr, netMgr, tableFactory, rootNetworkFactory));
	}

}
