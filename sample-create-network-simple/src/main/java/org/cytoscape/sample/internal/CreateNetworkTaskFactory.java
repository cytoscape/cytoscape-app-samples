package org.cytoscape.sample.internal;

import org.cytoscape.app.CyAppAdapter;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class CreateNetworkTaskFactory extends AbstractTaskFactory {

	private CyAppAdapter a;
	public CreateNetworkTaskFactory(CyAppAdapter a){
		this.a = a;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new CreateNetworkTask(a));
	}
}
