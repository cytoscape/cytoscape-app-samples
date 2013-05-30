package org.cytoscape.sample.internal;

import org.cytoscape.work.TaskIterator;
import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;

public class Sample09TaskFactory extends AbstractNetworkViewTaskFactory {

	public TaskIterator createTaskIterator(CyNetworkView networkView){
		return new TaskIterator(new Sample09Task(networkView) );
	}
}
