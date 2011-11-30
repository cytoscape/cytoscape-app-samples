package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample06TaskFactory implements TaskFactory {

	private CyApplicationManager appMgr;
	private CyNetworkViewFactory cnvf;
	private final CyNetworkViewManager networkViewManager;
	
	public Sample06TaskFactory(CyApplicationManager appMgr, CyNetworkViewFactory cnvf,
			 final CyNetworkViewManager networkViewManager){
		this.appMgr = appMgr;
		this.cnvf = cnvf;
		this.networkViewManager = networkViewManager;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new MyNetworkViewTask(appMgr, cnvf, networkViewManager));
	}
}
