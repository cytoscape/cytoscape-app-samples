package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import org.cytoscape.app.swing.CySwingAppAdapter;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.subnetwork.CyRootNetwork;


public class CreateNestedNetworkAction extends AbstractCyAction {

	private static final long serialVersionUID = 1L;
	private final CySwingAppAdapter adapter;
	
	public CreateNestedNetworkAction(CySwingAppAdapter adapter){
		// Add a menu item
		super("Create Nested Network");
		setPreferredMenu("Apps.Samples");

		this.adapter = adapter;		
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {

		//1. create an overview network for two nested network
		CyNetwork overview = this.adapter.getCyNetworkFactory().createNetwork();
		overview.getRow(overview).set("name", "Overview network");
		
		CyNode node1 = overview.addNode();
		CyNode node2 = overview.addNode();
		this.adapter.getCyNetworkManager().addNetwork(overview);

		//2. create two networks in the same network collection		
		CyNetwork network1 = this.adapter.getCyNetworkFactory().createNetwork();
		network1.getRow(network1).set("name", "Network 1");
		network1.addNode(); // add one node
		this.adapter.getCyNetworkManager().addNetwork(network1);
		
		CyRootNetwork rootNetwork = this.adapter.getCyRootNetworkManager().getRootNetwork(network1);
		
		CyNetwork network2 = rootNetwork.addSubNetwork();
		network2.getRow(network2).set("name", "Network 2");
		network2.addNode(); // add one node
		this.adapter.getCyNetworkManager().addNetwork(network2);
		
		// 3. set the two network as nested network of the overview network
		node1.setNetworkPointer(network1);
		node2.setNetworkPointer(network2);
	}
}
