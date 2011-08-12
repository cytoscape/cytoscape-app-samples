package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.work.TaskIterator;


public class Sample10TaskFactory extends AbstractNetworkViewTaskFactory {

	private CyApplicationManager appMgr;
	
	public Sample10TaskFactory(CyApplicationManager appMgr) {
		this.appMgr = appMgr;
	}
	
	public TaskIterator getTaskIterator() {
		this.view =  this.appMgr.getCurrentNetworkView();	
		
		return new TaskIterator(new ZoomTask(this.view));
	} 
}
