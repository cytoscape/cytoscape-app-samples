package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;

public class Sample09TaskFactory extends AbstractNetworkViewTaskFactory {

	private final CyApplicationManager appMgr;
	
	public Sample09TaskFactory(final CyApplicationManager appMgr){
		this.appMgr = appMgr;
	}
	
	public TaskIterator createTaskIterator(){
		CyNetworkView currView = appMgr.getCurrentNetworkView();
		return new TaskIterator(new Sample09Task(currView) );
	}
}
