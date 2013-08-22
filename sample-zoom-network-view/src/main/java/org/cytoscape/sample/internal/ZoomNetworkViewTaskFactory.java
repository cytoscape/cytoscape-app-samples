package org.cytoscape.sample.internal;

import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskIterator;


public class ZoomNetworkViewTaskFactory extends AbstractNetworkViewTaskFactory {

	public TaskIterator createTaskIterator(CyNetworkView networkView) {
		return new TaskIterator(new ZoomNetworkViewTask(networkView));
	} 
}
