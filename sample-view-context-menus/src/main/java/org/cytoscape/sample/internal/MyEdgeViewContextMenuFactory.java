package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.cytoscape.application.swing.CyEdgeViewContextMenuFactory;
import org.cytoscape.application.swing.CyMenuItem;
import org.cytoscape.model.CyEdge;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;

public class MyEdgeViewContextMenuFactory implements CyEdgeViewContextMenuFactory, ActionListener  {

	@Override
	public CyMenuItem createMenuItem(CyNetworkView netView,
			View<CyEdge> edgeView) {
		JMenuItem menuItem = new JMenuItem("Edge View Context Menu Item");
		menuItem.addActionListener(this);
		CyMenuItem cyMenuItem = new CyMenuItem(menuItem, 0);
		return cyMenuItem;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Write your own function here.
		JOptionPane.showMessageDialog(null, "MyEdgeViewContextMenuFactory action worked.");
	}
	
}
