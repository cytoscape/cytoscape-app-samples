package org.cytoscape.sample.internal;

import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample09TaskFactory implements TaskFactory {

	private final CyApplicationManager appMgr;
	
	public Sample09TaskFactory(final CyApplicationManager appMgr){
		this.appMgr = appMgr;
	}
	
	public TaskIterator getTaskIterator(){
		return new TaskIterator(new Sample09Task(appMgr));
	}
}
