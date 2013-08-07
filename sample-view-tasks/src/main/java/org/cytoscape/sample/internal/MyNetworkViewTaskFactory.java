package org.cytoscape.sample.internal;

import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskIterator;


public class MyNetworkViewTaskFactory extends AbstractNetworkViewTaskFactory {
	
	public TaskIterator createTaskIterator(CyNetworkView view) {
		return new TaskIterator(new MyNetworkViewTask(view) );
	}

}
