package org.cytoscape.sample.internal;

import java.util.List;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTableUtil;
import org.cytoscape.task.AbstractNetworkTask;
import org.cytoscape.work.TaskMonitor;

public class MyTask  extends AbstractNetworkTask {
	
	public MyTask(CyNetwork network){
		super(network);
	}
	public void run(TaskMonitor monitor) {
		
		if (this.network == null){			
			return;
		}

		//Get the selected nodes, but only create network if nodes are actually selected.
		List<CyNode> nodes = CyTableUtil.getNodesInState(this.network,"selected",true);
		
		System.out.println("Number of selected nodes are "+nodes.size());

	}
}
