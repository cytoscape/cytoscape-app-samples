package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTableUtil;

public class GetSelectedNodesAction extends AbstractCyAction {
	
	private static final long serialVersionUID = 1L;
	private CyApplicationManager cyApplicationManager;
	
	public GetSelectedNodesAction(CyApplicationManager cyApplicationManager){
		super("Get Selected Nodes");
		setPreferredMenu("Apps.Samples");
		this.cyApplicationManager = cyApplicationManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (cyApplicationManager.getCurrentNetwork() == null){			
			return;
		}

		//Get the selected nodes
		List<CyNode> nodes = CyTableUtil.getNodesInState(cyApplicationManager.getCurrentNetwork(),"selected",true);
		
		JOptionPane.showMessageDialog(null, "Number of selected nodes are "+nodes.size());
	}
}
