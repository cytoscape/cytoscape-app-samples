package org.cytoscape.sample.internal;

import static org.cytoscape.view.presentation.property.MinimalVisualLexicon.NETWORK_SCALE_FACTOR;
import org.cytoscape.task.AbstractNetworkViewTask;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;


public class ZoomTask extends AbstractNetworkViewTask {

	@Tunable(description="Scale")
	public double scale = 0.2; // Default value

	ZoomTask(CyNetworkView v) {
		super(v);
	}

	public void run(TaskMonitor tm) {
		
		if(this.view == null){
			return;
		}
		
		double newScale = view.getVisualProperty(NETWORK_SCALE_FACTOR).doubleValue() * scale;
		view.setVisualProperty(NETWORK_SCALE_FACTOR, newScale);
		
		view.updateView();
	}
}
