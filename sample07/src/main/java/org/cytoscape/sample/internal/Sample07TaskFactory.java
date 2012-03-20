package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.task.AbstractNetworkTaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample07TaskFactory extends AbstractNetworkTaskFactory {

	public TaskIterator createTaskIterator(CyNetwork network) {
		return new TaskIterator(new MyTask(network));
	}
}
