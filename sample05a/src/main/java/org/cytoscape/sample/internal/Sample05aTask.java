package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTableEntry;
import org.cytoscape.plugin.CyPluginAdapter;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class Sample05aTask extends AbstractTask {

	private CyPluginAdapter adapter;
	
	public Sample05aTask(CyPluginAdapter a) {
		this.adapter = a;
	}
	
	public void run(TaskMonitor monitor) {
		// Create an empty network
		CyNetwork myNet = adapter.getCyNetworkFactory().getInstance();
		myNet.getCyRow().set(CyTableEntry.NAME, "My network");
				     // adapter.namingUtil.getSuggestedNetworkTitle("My Network"));
		
		// Add two nodes to the network
		CyNode node1 = myNet.addNode();
		CyNode node2 = myNet.addNode();
		
		// Add an edge
		myNet.addEdge(node1, node2, true);
				
		adapter.getCyNetworkManager().addNetwork(myNet);
		
		//// The following code will destroy a network
		boolean destroyNetwork = false;
		if (destroyNetwork){
			// Get current network
			CyNetwork currNet = adapter.getCyApplicationManager().getCurrentNetwork();
			// Destroy it
			 adapter.getCyNetworkManager().destroyNetwork(currNet);			
		}
	}
}
