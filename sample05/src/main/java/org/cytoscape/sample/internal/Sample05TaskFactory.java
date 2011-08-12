package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample05TaskFactory implements TaskFactory {
	private CyApplicationManager appMgr;
	private final CyNetworkManager netMgr;
	private final CyNetworkFactory cnf;
	private final CyNetworkNaming namingUtil; 
	
	public Sample05TaskFactory(CyApplicationManager appMgr, final CyNetworkManager netMgr, 
			final CyNetworkNaming namingUtil, final CyNetworkFactory cnf){
		this.appMgr = appMgr;
		this.netMgr = netMgr;
		this.namingUtil = namingUtil;
		this.cnf = cnf;
	}
	
	public TaskIterator getTaskIterator(){
		return new TaskIterator(new MyNetworkTask(appMgr, netMgr, namingUtil, cnf));
	}
}
