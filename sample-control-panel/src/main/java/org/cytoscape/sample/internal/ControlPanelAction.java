package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;

import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.swing.CytoPanel;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.application.swing.CytoPanelState;


public class ControlPanelAction extends AbstractCyAction {

	private static final long serialVersionUID = 1L;
	private CySwingApplication desktopApp;
	private final CytoPanel cytoPanelWest;
	private MyControlPanel myControlPanel;
	
	public ControlPanelAction(CySwingApplication desktopApp,
			MyControlPanel myCytoPanel){
		// Add a menu item -- Apps->sample02
		super("Control Panel");
		setPreferredMenu("Apps.Samples");

		this.desktopApp = desktopApp;
		
		//Note: myControlPanel is bean we defined and registered as a service
		this.cytoPanelWest = this.desktopApp.getCytoPanel(CytoPanelName.WEST);
		this.myControlPanel = myCytoPanel;
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {
		// If the state of the cytoPanelWest is HIDE, show it
		if (cytoPanelWest.getState() == CytoPanelState.HIDE) {
			cytoPanelWest.setState(CytoPanelState.DOCK);
		}	

		// Select my panel
		int index = cytoPanelWest.indexOfComponent(myControlPanel);
		if (index == -1) {
			return;
		}
		cytoPanelWest.setSelectedIndex(index);
	}

}
