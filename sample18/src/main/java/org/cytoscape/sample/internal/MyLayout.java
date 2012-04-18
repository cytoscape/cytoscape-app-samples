package org.cytoscape.sample.internal;

import java.util.Set;

import org.cytoscape.model.CyNode;
import org.cytoscape.view.layout.AbstractLayoutAlgorithm;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.work.TaskIterator;

public class MyLayout extends AbstractLayoutAlgorithm<MyLayoutContext> {

	
	/**
	 * Creates a new MyLayout object.
	 */
	public MyLayout() {
		super("computer name","human name");
	}
	
	public TaskIterator createTaskIterator(CyNetworkView networkView, MyLayoutContext context, Set<View<CyNode>> nodesToLayOut) {
		return new TaskIterator(new MyLayoutTask(getName(), networkView, context, nodesToLayOut, getSupportedNodeAttributeTypes(), getSupportedEdgeAttributeTypes(), getInitialAttributeList()));
	}

	public MyLayoutContext createLayoutContext() {
		return new MyLayoutContext();
	}
}
