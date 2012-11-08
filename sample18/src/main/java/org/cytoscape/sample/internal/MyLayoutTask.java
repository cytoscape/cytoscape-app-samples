package org.cytoscape.sample.internal;

import java.util.Random;
import java.util.Set;

import org.cytoscape.model.CyNode;
import org.cytoscape.view.layout.AbstractLayoutTask;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.model.VisualProperty;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.undo.UndoSupport;

public class MyLayoutTask extends AbstractLayoutTask {

	private int XRange;
	private int YRange;
	
	public MyLayoutTask(final String displayName, CyNetworkView networkView, final MyLayoutContext context, Set<View<CyNode>> nodesToLayOut, String attrName, UndoSupport undo) {
		super(displayName, networkView, nodesToLayOut, attrName, undo);
	
		this.XRange = context.XRange;
		this.YRange = context.YRange;
	}
	
	/**
	 *  Perform actual layout task.
	 *  This creates the default square layout.
	 */
	@Override
	final protected void doLayout(final TaskMonitor taskMonitor) {

		double currX = 0.0d;
		double currY = 0.0d;
		
		final VisualProperty<Double> xLoc = BasicVisualLexicon.NODE_X_LOCATION;
		final VisualProperty<Double> yLoc = BasicVisualLexicon.NODE_Y_LOCATION;
		
		Random randomGenerator = new Random();
		
		// Set visual property.
		for (final View<CyNode> nView : nodesToLayOut ) {

			// Shift current nodeView to a new position based on a random value
			currX = nView.getVisualProperty(xLoc) + XRange*randomGenerator.nextDouble();
			currY = nView.getVisualProperty(yLoc) + YRange*randomGenerator.nextDouble();
			
			nView.setVisualProperty(xLoc,currX);
			nView.setVisualProperty(yLoc,currY);
		}		
	}
}
