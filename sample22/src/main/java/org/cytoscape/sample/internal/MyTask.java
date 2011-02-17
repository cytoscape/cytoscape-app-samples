package org.cytoscape.sample.internal;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class MyTask extends AbstractTask {

	public MyTask(){
	}
	
    @Override
	public void run(final TaskMonitor taskMonitor) {
		// Give the task a title.
		taskMonitor.setTitle("My task");

		taskMonitor.setProgress(10);
		
		try {
			Thread.sleep(4000);
		}
		catch ( InterruptedException e){
		}

		taskMonitor.setProgress(50);
		
		try {
			Thread.sleep(4000);
		}
		catch ( InterruptedException e){
		}
		taskMonitor.setProgress(100);
    }
    
    @Override
    public void cancel() {
    }
}
