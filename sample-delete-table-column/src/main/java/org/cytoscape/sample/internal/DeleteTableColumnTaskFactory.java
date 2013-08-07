package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class DeleteTableColumnTaskFactory extends AbstractTaskFactory {

	private CyApplicationManager appMgr;
	
	public DeleteTableColumnTaskFactory(CyApplicationManager appMgr){
		this.appMgr = appMgr;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new DeleteTableColumnTask(this.appMgr.getCurrentNetwork()));
	}
}
