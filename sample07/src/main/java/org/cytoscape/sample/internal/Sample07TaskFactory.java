package org.cytoscape.sample.internal;

import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.task.AbstractNetworkTaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample07TaskFactory extends AbstractNetworkTaskFactory {

	private CyApplicationManager appMgr;
	
	public Sample07TaskFactory(CyApplicationManager appMgr){
		this.appMgr = appMgr;
	}
	
	public TaskIterator getTaskIterator() {
		
		this.net = this.appMgr.getCurrentNetworkView().getModel();
		return new TaskIterator(new MyTask(this.net));
	}
}
