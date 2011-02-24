package org.cytoscape.sample.internal;

import org.cytoscape.task.AbstractNodeViewTaskFactory;
import org.cytoscape.work.TaskIterator;


public class MyNodeViewTaskFactory extends AbstractNodeViewTaskFactory {
	public TaskIterator getTaskIterator() {
		return new TaskIterator(new MyNodeViewTask(nodeView, netView));
	} 
}
