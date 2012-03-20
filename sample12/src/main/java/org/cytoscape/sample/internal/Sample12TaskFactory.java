package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample12TaskFactory extends AbstractTaskFactory {

	private CyApplicationManager appMgr;
	
	public Sample12TaskFactory(CyApplicationManager appMgr){
		this.appMgr = appMgr;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new DeleteAttributeTask(this.appMgr.getCurrentNetwork()));
	}
}
