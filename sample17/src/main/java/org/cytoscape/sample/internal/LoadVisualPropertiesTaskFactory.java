package org.cytoscape.sample.internal;

import org.cytoscape.task.creation.LoadVisualStyles;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class LoadVisualPropertiesTaskFactory implements TaskFactory {


	private final LoadVisualStyles loadVizmapFileTaskFactory;
	
	public LoadVisualPropertiesTaskFactory(LoadVisualStyles loadVizmapFileTaskFactory){
		this.loadVizmapFileTaskFactory = loadVizmapFileTaskFactory;
	}
	
	
	@Override
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new LoadVisualPropertiesTask(this.loadVizmapFileTaskFactory));
	}

}
