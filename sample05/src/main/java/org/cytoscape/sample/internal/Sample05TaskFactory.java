package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample05TaskFactory implements TaskFactory {
	private final CyNetworkManager netMgr;
	private final CyNetworkFactory cnf;
	private final CyNetworkNaming namingUtil; 
	
	public Sample05TaskFactory(final CyNetworkManager netMgr, 
			final CyNetworkNaming namingUtil, final CyNetworkFactory cnf){
		this.netMgr = netMgr;
		this.namingUtil = namingUtil;
		this.cnf = cnf;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new MyNetworkTask(netMgr, namingUtil, cnf));
	}
}
