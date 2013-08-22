package org.cytoscape.sample.internal;

import java.awt.Color;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.task.AbstractNetworkViewTask;

public class SetNetworkBackgroundColorTask extends AbstractNetworkViewTask {

	public SetNetworkBackgroundColorTask(CyNetworkView view) {
		super(view);
	}
	
    @Override
	public void run(final TaskMonitor taskMonitor) {
    	if(view == null){
    		return;
    	}
    	// Set the background of current view to RED 	
    	view.setVisualProperty(BasicVisualLexicon.NETWORK_BACKGROUND_PAINT, Color.red);
    	view.updateView();
    }
}
