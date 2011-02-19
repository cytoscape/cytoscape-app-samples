package org.cytoscape.sample.internal;

import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample12TaskFactory implements TaskFactory {

	private CyApplicationManager appMgr;
	
	public Sample12TaskFactory(CyApplicationManager appMgr){
		this.appMgr = appMgr;
	}
	
	public TaskIterator getTaskIterator(){
		return new TaskIterator(new DeleteAttributeTask(appMgr));
	}
}
