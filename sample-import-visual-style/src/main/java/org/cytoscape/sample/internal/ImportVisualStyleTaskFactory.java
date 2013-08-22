package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.task.read.LoadVizmapFileTaskFactory;
import org.cytoscape.task.visualize.ApplyVisualStyleTaskFactory;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class ImportVisualStyleTaskFactory extends AbstractTaskFactory {

	private final LoadVizmapFileTaskFactory loadVizmapFileTaskFactory;
	private final CyApplicationManager cyApplicationManagerServiceRef;
	private final ApplyVisualStyleTaskFactory applyVisualStyleTaskFactory;
	
	public ImportVisualStyleTaskFactory(LoadVizmapFileTaskFactory loadVizmapFileTaskFactory, CyApplicationManager cyApplicationManagerServiceRef,
			ApplyVisualStyleTaskFactory applyVisualStyleTaskFactory){
		this.loadVizmapFileTaskFactory = loadVizmapFileTaskFactory;
		this.cyApplicationManagerServiceRef = cyApplicationManagerServiceRef;
		this.applyVisualStyleTaskFactory = applyVisualStyleTaskFactory;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new ImportVisualStyleTask(this.loadVizmapFileTaskFactory, this.cyApplicationManagerServiceRef.getCurrentNetworkView(),
				this.applyVisualStyleTaskFactory));
	}
}
