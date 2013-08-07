package org.cytoscape.sample.internal;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;


public class UseTaskMonitorTaskFactory extends AbstractTaskFactory {

	public UseTaskMonitorTaskFactory(){
		
	}
	
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new UseTaskMonitorTask());
	}
	
}
