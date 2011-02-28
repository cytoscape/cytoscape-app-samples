package org.cytoscape.sample.internal;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.Tunable;
import org.cytoscape.work.swing.GUITaskManager;
import org.cytoscape.view.model.CyNetworkView;

public class Sample10TaskFactory extends AbstractNetworkViewTaskFactory {

	private CyApplicationManager appMgr;
	
	public Sample10TaskFactory(CyApplicationManager appMgr) {
		this.appMgr = appMgr;
	}
	
	public TaskIterator getTaskIterator() {
		this.view =  this.appMgr.getCurrentNetworkView();	
		
		return new TaskIterator(new ZoomTask(this.view));
	} 
}
