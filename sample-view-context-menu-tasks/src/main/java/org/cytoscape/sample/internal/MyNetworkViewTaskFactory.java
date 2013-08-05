package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskIterator;


public class MyNetworkViewTaskFactory extends AbstractNetworkViewTaskFactory {

	private final CyApplicationManager applicationManager;

	
	public MyNetworkViewTaskFactory(CyApplicationManager applicationManager){
		this.applicationManager = applicationManager;
	}
	
	
	public TaskIterator createTaskIterator(CyNetworkView view) {
		return new TaskIterator(new MyNetworkViewTask(this.applicationManager.getCurrentNetworkView()) );
	}

}
