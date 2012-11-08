package org.cytoscape.sample.internal;

import java.util.Set;

import org.cytoscape.model.CyNode;
import org.cytoscape.view.layout.AbstractLayoutAlgorithm;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.undo.UndoSupport;

public class MyLayout extends AbstractLayoutAlgorithm {

	
	/**
	 * Creates a new MyLayout object.
	 */
	public MyLayout(UndoSupport undo) {
		super("computer name","human name", undo);
	}
	
	public TaskIterator createTaskIterator(CyNetworkView networkView, Object context, Set<View<CyNode>> nodesToLayOut, String attrName) {
		return new TaskIterator(new MyLayoutTask(toString(), networkView, (MyLayoutContext)context, nodesToLayOut,attrName, undoSupport));
	}

	public Object createLayoutContext() {
		return new MyLayoutContext();
	}
}
