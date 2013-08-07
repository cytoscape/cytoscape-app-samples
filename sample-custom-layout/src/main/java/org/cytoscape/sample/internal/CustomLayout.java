package org.cytoscape.sample.internal;

import java.util.Random;
import java.util.Set;

import org.cytoscape.model.CyNode;
import org.cytoscape.view.layout.AbstractLayoutAlgorithm;
import org.cytoscape.view.layout.AbstractLayoutTask;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.model.VisualProperty;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.work.Task;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.undo.UndoSupport;

public class CustomLayout extends AbstractLayoutAlgorithm {
	/**
	 * Creates a new MyLayout object.
	 */
	public CustomLayout(UndoSupport undo) {
		super("customLayout","Custom Layout", undo);
	}
	
	public TaskIterator createTaskIterator(CyNetworkView networkView, Object context, Set<View<CyNode>> nodesToLayOut, String attrName) {
		final CustomLayoutContext myContext = (CustomLayoutContext) context;
		Task task = new AbstractLayoutTask(toString(), networkView, nodesToLayOut, attrName, undoSupport) {
			@Override
			protected void doLayout(TaskMonitor taskMonitor) {
				double currX = 0.0d;
				double currY = 0.0d;
				
				final VisualProperty<Double> xLoc = BasicVisualLexicon.NODE_X_LOCATION;
				final VisualProperty<Double> yLoc = BasicVisualLexicon.NODE_Y_LOCATION;
				
				Random randomGenerator = new Random();
				
				// Set visual property.
				for (final View<CyNode> nView : nodesToLayOut ) {

					// Shift current nodeView to a new position based on a random value
					currX = nView.getVisualProperty(xLoc) + myContext.XRange * randomGenerator.nextDouble();
					currY = nView.getVisualProperty(yLoc) + myContext.YRange * randomGenerator.nextDouble();
					
					nView.setVisualProperty(xLoc,currX);
					nView.setVisualProperty(yLoc,currY);
				}		
			}
		};
		return new TaskIterator(task);
	}

	public Object createLayoutContext() {
		return new CustomLayoutContext();
	}
}
