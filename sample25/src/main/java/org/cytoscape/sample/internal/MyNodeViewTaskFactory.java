package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.task.AbstractNodeViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.work.TaskIterator;

public class MyNodeViewTaskFactory extends AbstractNodeViewTaskFactory {

	
	public MyNodeViewTaskFactory(){
	}
	
	
	@Override
	public TaskIterator createTaskIterator(View<CyNode> nodeView, CyNetworkView networkView) {
		return new TaskIterator(new MyNodeViewTask(nodeView, networkView));
	}

}
