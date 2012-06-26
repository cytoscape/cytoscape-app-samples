package org.cytoscape.sample.sample26.internal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.cytoscape.application.swing.CyMenuItem;
import org.cytoscape.application.swing.CyNodeViewContextMenuFactory;
import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;

public class CyNodeVCMFSample implements CyNodeViewContextMenuFactory, ActionListener{

	@Override
	public CyMenuItem createMenuItem(CyNetworkView netView,
			View<CyNode> nodeView) {
		
		JMenuItem jMenu = new JMenuItem("sample CyNodeVCMF");
		jMenu.addActionListener(this);
		CyMenuItem newMenu = new CyMenuItem(jMenu, 1);
		return newMenu;
		
	}

	public void actionPerformed(ActionEvent e) {

		// Write your own function here.
		JOptionPane.showMessageDialog(null, "CyNodeViewContextMenuFactory worked!");
		
	}
}
