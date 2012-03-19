package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.task.AbstractNetworkTaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample07TaskFactory extends AbstractNetworkTaskFactory {

	private final CyApplicationManager cyApplicationManagerService;
	
	public Sample07TaskFactory(CyApplicationManager cyApplicationManagerService){
		this.cyApplicationManagerService = cyApplicationManagerService;
	}
	
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new MyTask(this.cyApplicationManagerService.getCurrentNetwork()));
	}
}
