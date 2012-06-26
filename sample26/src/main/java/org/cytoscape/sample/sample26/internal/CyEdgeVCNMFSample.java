package org.cytoscape.sample.sample26.internal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.cytoscape.application.swing.CyEdgeViewContextMenuFactory;
import org.cytoscape.application.swing.CyMenuItem;
import org.cytoscape.model.CyEdge;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;

public class CyEdgeVCNMFSample implements CyEdgeViewContextMenuFactory, ActionListener  {

	@Override
	public CyMenuItem createMenuItem(CyNetworkView netView,
			View<CyEdge> edgeView) {
		JMenuItem newMenuItem = new JMenuItem("Sample cyEdgeVNMF");
		newMenuItem.addActionListener(this);
		CyMenuItem edgeMenu = new CyMenuItem(newMenuItem, 1);
		return edgeMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Write your own function here.
		JOptionPane.showMessageDialog(null, "CyEdgeViewContextMenuFactory action worked!");
		
	}
	
}
