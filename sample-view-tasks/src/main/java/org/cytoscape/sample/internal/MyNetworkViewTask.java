package org.cytoscape.sample.internal;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.view.model.CyNetworkView;

public class MyNetworkViewTask extends AbstractTask {

	private CyNetworkView view;
	public MyNetworkViewTask(CyNetworkView view){
		this.view = view;
	}
	
    @Override
	public void run(final TaskMonitor taskMonitor) {
		// Give the task a title.
		taskMonitor.setTitle("My Network View Task");
		
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
