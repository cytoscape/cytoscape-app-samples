package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class ChangeNodeBorderWidthTaskFactory extends AbstractTaskFactory {

	private final CyApplicationManager cyApplicationManagerServiceRef;
	private final VisualMappingManager vmmServiceRef;
	
	public ChangeNodeBorderWidthTaskFactory(final CyApplicationManager cyApplicationManagerServiceRef, VisualMappingManager vmmServiceRef){
		this.cyApplicationManagerServiceRef = cyApplicationManagerServiceRef;
		this.vmmServiceRef = vmmServiceRef;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new ChangeNodeBorderWidthTask(cyApplicationManagerServiceRef.getCurrentNetworkView(), vmmServiceRef));
	}
}
