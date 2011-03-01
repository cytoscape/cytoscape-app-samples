package org.cytoscape.sample.internal;

import org.cytoscape.plugin.CyPluginAdapter;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample05aTaskFactory implements TaskFactory {

	private CyPluginAdapter a;
	public Sample05aTaskFactory(CyPluginAdapter a){
		this.a = a;
	}
	
	public TaskIterator getTaskIterator(){
		return new TaskIterator(new Sample05aTask(a));
	}
}
