package org.cytoscape.sample.internal;

import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class UseWebServiceTaskFactory implements TaskFactory {

	private final WebServiceHelper wsh;
	public UseWebServiceTaskFactory(WebServiceHelper wsh){
		this.wsh = wsh;
	}
	
	@Override
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new UseWebServiceTask(wsh));
	}
}
