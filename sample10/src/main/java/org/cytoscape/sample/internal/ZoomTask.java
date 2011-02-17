package org.cytoscape.sample.internal;

import static org.cytoscape.view.presentation.property.TwoDVisualLexicon.NETWORK_SCALE_FACTOR;
import org.cytoscape.task.AbstractNetworkViewTask;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskMonitor;


class ZoomTask extends AbstractNetworkViewTask {

	protected double factor;

	ZoomTask(CyNetworkView v, double factor) {
		super(v);
		this.factor = factor;
	}

	public void run(TaskMonitor tm) {
		view.setVisualProperty(NETWORK_SCALE_FACTOR, 
		view.getVisualProperty(NETWORK_SCALE_FACTOR).doubleValue() * factor);
		
		view.updateView();
	}
}
