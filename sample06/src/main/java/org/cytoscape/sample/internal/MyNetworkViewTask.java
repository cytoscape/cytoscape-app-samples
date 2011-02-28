package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class MyNetworkViewTask extends AbstractTask {
		
		private CyApplicationManager appMgr;
	    private final CyNetworkViewFactory cnvf;
	    private  final CyNetworkViewManager networkViewManager;
		
		public MyNetworkViewTask(CyApplicationManager appMgr, CyNetworkViewFactory cnvf,
				 final CyNetworkViewManager networkViewManager){
			this.appMgr = appMgr;
			this.cnvf = cnvf;
			this.networkViewManager = networkViewManager;
		}
		
		public void run(TaskMonitor monitor) {

			// Get current network
			CyNetwork currNet = appMgr.getCurrentNetwork();

			if(currNet == null){
				return;
			}

			if(networkViewManager.getNetworkView(currNet.getSUID()) == null){
				// create a new view for current network
				CyNetworkView myView = cnvf.getNetworkView(currNet);
				networkViewManager.addNetworkView(myView);				
			}
			else {
				System.out.println("networkView already existed!");
			}
			
			// Set the variable destroyView to true, the following snippet of code will destroy a networkview
			boolean destroyView = false;
			if(destroyView)
			{
				CyNetwork currNetwork = appMgr.getCurrentNetwork();
				CyNetworkView view = networkViewManager.getNetworkView(currNetwork.getSUID());
				networkViewManager.destroyNetworkView(view);				
			}
		}

}
