package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;

import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.swing.CytoPanel;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.application.swing.CytoPanelState;
import org.cytoscape.session.CyApplicationManager;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.cytoscape.application.swing.CytoPanelComponent;

public class AddTabbedPanelAction extends AbstractCyAction {

	private CySwingApplication desktopApp;
	private final CytoPanel cytoPanelWest;
	private MyCytoPanel myCytoPanel;
	
	public AddTabbedPanelAction(CyApplicationManager applicationManager, CySwingApplication desktopApp,
			MyCytoPanel myCytoPanel){
		
		super("sample02", applicationManager);
		setPreferredMenu("Plugins");

		this.desktopApp = desktopApp;
		
		cytoPanelWest = desktopApp.getCytoPanel(CytoPanelName.WEST);
		this.myCytoPanel = myCytoPanel;
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {
		// If the state of the cytoPanelEast is HIDE, show it
		if (cytoPanelWest.getState() == CytoPanelState.HIDE) {
			cytoPanelWest.setState(CytoPanelState.DOCK);
		}	

		// Select my panel
		int index = cytoPanelWest.indexOfComponent(myCytoPanel);
		if (index == -1) {
			return;
		}
		
		cytoPanelWest.setSelectedIndex(index);
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @return  DOCUMENT ME!
	 */
	public boolean isInToolBar() {
		return false;
	}

	/**
	 *  DOCUMENT ME!
	 *
	 * @return  DOCUMENT ME!
	 */
	public boolean isInMenuBar() {
		return true;
	}
}
