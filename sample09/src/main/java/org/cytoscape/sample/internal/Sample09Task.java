package org.cytoscape.sample.internal;

import java.awt.Color;
import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.presentation.property.TwoDVisualLexicon;

public class Sample09Task extends AbstractTask {

	private CyApplicationManager appMgr;
	
	public Sample09Task(final CyApplicationManager appMgr){
		this.appMgr = appMgr;
	}
	
    @Override
	public void run(final TaskMonitor taskMonitor) {
    	
    	// Set the background of current view to RED
    	CyNetworkView currView = appMgr.getCurrentNetworkView();    	
    	currView.setVisualProperty(TwoDVisualLexicon.NETWORK_BACKGROUND_PAINT, Color.red);
    	currView.updateView();
    }
}
