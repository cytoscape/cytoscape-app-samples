package org.cytoscape.sample.internal;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class UseWebServiceTaskFactory extends AbstractTaskFactory {

	private final WebServiceHelper wsh;
	public UseWebServiceTaskFactory(WebServiceHelper wsh){
		this.wsh = wsh;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new UseWebServiceTask(wsh));
	}
}
