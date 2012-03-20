package org.cytoscape.sample.internal;

import org.cytoscape.view.layout.AbstractLayoutAlgorithm;
import org.cytoscape.work.TaskIterator;

public class MyLayout extends AbstractLayoutAlgorithm<MyLayoutContext> {

	
	/**
	 * Creates a new MyLayout object.
	 */
	public MyLayout() {
		super("computer name","human name",true);
	}
	
	public TaskIterator createTaskIterator(MyLayoutContext context) {
		return new TaskIterator(new MyLayoutTask(context, getName()));
	}

	public MyLayoutContext createLayoutContext() {
		return new MyLayoutContext(supportsSelectedOnly(), supportsNodeAttributes(), supportsEdgeAttributes());
	}
}
