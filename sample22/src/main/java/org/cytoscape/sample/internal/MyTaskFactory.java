package org.cytoscape.sample.internal;

import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;


public class MyTaskFactory implements TaskFactory {

	public TaskIterator getTaskIterator() {
		return new TaskIterator(new MyTask());
	}
	
}
