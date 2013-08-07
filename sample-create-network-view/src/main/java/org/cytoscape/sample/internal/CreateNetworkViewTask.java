package org.cytoscape.sample.internal;

import java.util.Collection;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class CreateNetworkViewTask extends AbstractTask {

	private final CyNetworkFactory cnf;
	private final CyNetworkViewFactory cnvf;
	private final CyNetworkViewManager networkViewManager;
	private final CyNetworkManager networkManager;
	private final CyNetworkNaming cyNetworkNaming;

	public CreateNetworkViewTask(CyNetworkNaming cyNetworkNaming, CyNetworkFactory cnf, CyNetworkManager networkManager,
			CyNetworkViewFactory cnvf, final CyNetworkViewManager networkViewManager) {
		this.cnf = cnf;
		this.cnvf = cnvf;
		this.networkViewManager = networkViewManager;
		this.networkManager = networkManager;
		this.cyNetworkNaming = cyNetworkNaming;
	}

	public void run(TaskMonitor monitor) {

		// Create an empty network
		CyNetwork myNet = this.cnf.createNetwork();

		// add a node to the network
		CyNode node1 = myNet.addNode();

		// set name for the new node
		myNet.getDefaultNodeTable().getRow(node1.getSUID()).set("name", "Node1");

		myNet.getDefaultNetworkTable().getRow(myNet.getSUID())
				.set("name", cyNetworkNaming.getSuggestedNetworkTitle("My Network"));

		if (myNet == null)
			return;
		this.networkManager.addNetwork(myNet);

		final Collection<CyNetworkView> views = networkViewManager.getNetworkViews(myNet);
		CyNetworkView myView = null;
		if(views.size() != 0)
			myView = views.iterator().next();
		
		if (myView == null) {
			// create a new view for my network
			myView = cnvf.createNetworkView(myNet);
			networkViewManager.addNetworkView(myView);
		} else {
			System.out.println("networkView already existed.");
		}

		// Set the variable destroyView to true, the following snippet of code
		// will destroy a view
		boolean destroyView = false;
		if (destroyView) {
			networkViewManager.destroyNetworkView(myView);
		}
	}

}
