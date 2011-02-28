package org.cytoscape.sample.internal;

import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;


public class Sample22TaskFactory implements TaskFactory {

	public Sample22TaskFactory(){
		
	}
	
	public TaskIterator getTaskIterator() {
		return new TaskIterator(new MyTask());
	}
	
}
