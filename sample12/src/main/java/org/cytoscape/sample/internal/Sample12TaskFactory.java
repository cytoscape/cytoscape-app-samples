package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.model.CyNetwork;

public class Sample12TaskFactory implements TaskFactory {

	private CyApplicationManager appMgr;
	
	public Sample12TaskFactory(CyApplicationManager appMgr){
		this.appMgr = appMgr;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new DeleteAttributeTask(this.appMgr.getCurrentNetwork()));
	}
}
