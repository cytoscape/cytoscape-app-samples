package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTableEntry;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class MyNetworkTask extends AbstractTask {
	
	private CyApplicationManager appMgr;
	private final CyNetworkManager netMgr;
	private final CyNetworkFactory cnf;
	private final CyNetworkNaming namingUtil; 
	
	public MyNetworkTask(CyApplicationManager appMgr, final CyNetworkManager netMgr, 
			final CyNetworkNaming namingUtil, final CyNetworkFactory cnf){
		this.appMgr = appMgr;
		this.netMgr = netMgr;
		this.cnf = cnf;
		this.namingUtil = namingUtil;
	}
	
	public void run(TaskMonitor monitor) {
		// Create an empty network
		CyNetwork myNet = cnf.getInstance();
		myNet.getCyRow().set(CyTableEntry.NAME,
				      namingUtil.getSuggestedNetworkTitle("My Network"));
		
		// Add two nodes to the network
		CyNode node1 = myNet.addNode();
		CyNode node2 = myNet.addNode();
		
		// Add an edge
		myNet.addEdge(node1, node2, true);
				
		netMgr.addNetwork(myNet);
		
		// Set the variable destroyNetwork to true, the following code will destroy a network
		boolean destroyNetwork = false;
		if (destroyNetwork){
			// Get current network
			CyNetwork currNet = appMgr.getCurrentNetwork();
			// Destroy it
			 netMgr.destroyNetwork(currNet);			
		}
	}

}
