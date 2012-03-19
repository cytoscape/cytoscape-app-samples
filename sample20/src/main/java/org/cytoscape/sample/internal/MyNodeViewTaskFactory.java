package org.cytoscape.sample.internal;

import org.cytoscape.task.AbstractNodeViewTaskFactory;
import org.cytoscape.work.TaskIterator;


public class MyNodeViewTaskFactory extends AbstractNodeViewTaskFactory {
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new MyNodeViewTask(nodeView, netView));
	} 
}
