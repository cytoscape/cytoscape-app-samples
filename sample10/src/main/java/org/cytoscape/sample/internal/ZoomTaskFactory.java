package org.cytoscape.sample.internal;

import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.view.model.CyNetworkView;

public class ZoomTaskFactory extends AbstractNetworkViewTaskFactory {

	private CyNetworkView view;
	private double scale;
	
	public ZoomTaskFactory(CyNetworkView view, double scale){
		this.view = view;
		this.scale = scale;
	}
	
	public TaskIterator getTaskIterator() {
		return new TaskIterator(new ZoomTask(view, scale));
	} 
}
