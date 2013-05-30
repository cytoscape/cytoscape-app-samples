package org.cytoscape.sample.internal;

import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskIterator;


public class Sample10TaskFactory extends AbstractNetworkViewTaskFactory {

	public TaskIterator createTaskIterator(CyNetworkView networkView) {
		return new TaskIterator(new ZoomTask(networkView));
	} 
}
