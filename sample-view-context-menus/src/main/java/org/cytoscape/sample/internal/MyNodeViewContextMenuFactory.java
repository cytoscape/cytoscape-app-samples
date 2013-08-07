package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.cytoscape.application.swing.CyMenuItem;
import org.cytoscape.application.swing.CyNodeViewContextMenuFactory;
import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;

public class MyNodeViewContextMenuFactory implements CyNodeViewContextMenuFactory, ActionListener{

	@Override
	public CyMenuItem createMenuItem(CyNetworkView netView,
			View<CyNode> nodeView) {
		JMenuItem menuItem = new JMenuItem("Node View Context Menu Item");
		menuItem.addActionListener(this);
		CyMenuItem cyMenuItem = new CyMenuItem(menuItem, 0);
		return cyMenuItem;
	}

	public void actionPerformed(ActionEvent e) {
		// Write your own function here.
		JOptionPane.showMessageDialog(null, "MyNodeViewContextMenuFactory action worked.");
	}
}
