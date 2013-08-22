package org.cytoscape.sample.internal;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.model.CyEdge;

public class MyEdgeViewTask extends AbstractTask {

	private CyNetworkView networkView;
	private View<CyEdge> edgeView;

	public MyEdgeViewTask(View<CyEdge> edgeView, CyNetworkView networkView){
		this.networkView = networkView;
		this.edgeView = edgeView;
	}
	
    @Override
	public void run(final TaskMonitor taskMonitor) {
		// Give the task a title.
		taskMonitor.setTitle("My Edge View Task");
		
		taskMonitor.setProgress(0.1);
		
		try {
			// Do something here with the view
			
			Thread.sleep(4000);
		}
		catch ( InterruptedException e){
		}
		taskMonitor.setProgress(1.0);
    }
}
