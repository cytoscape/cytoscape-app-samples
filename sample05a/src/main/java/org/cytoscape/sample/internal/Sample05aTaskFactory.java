package org.cytoscape.sample.internal;

import org.cytoscape.app.CyAppAdapter;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample05aTaskFactory implements TaskFactory {

	private CyAppAdapter a;
	public Sample05aTaskFactory(CyAppAdapter a){
		this.a = a;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new Sample05aTask(a));
	}
}
