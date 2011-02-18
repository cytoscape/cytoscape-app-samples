package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Set;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.CyTableUtil;


public class Sample07Action extends AbstractCyAction {

	private CyApplicationManager appMgr;
	
	public Sample07Action(CyApplicationManager appMgr){
		
		super("sample07", appMgr);
		setPreferredMenu("Plugins");

		this.appMgr = appMgr;
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {
		//
		
		if (this.appMgr.getCurrentNetworkView() == null){			
			return;
		}
		
		CyNetwork currNet = this.appMgr.getCurrentNetworkView().getModel();
		
		// Get the selected nodes, but only create network if nodes are actually selected.
		List<CyNode> nodes = CyTableUtil.getNodesInState(currNet,"selected",true);
		
		System.out.println("Number of selected nodes are "+nodes.size());
	
	}
	
}
