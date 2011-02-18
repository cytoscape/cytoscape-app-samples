package org.cytoscape.sample.internal;

import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class ImportAttributeTaskFactory implements TaskFactory{

	ImportAttributeTask task;
	
	public ImportAttributeTaskFactory(ImportAttributeTask task){
		this.task = task;
	}
	public TaskIterator getTaskIterator() {
		return new TaskIterator(task);
	}

}
