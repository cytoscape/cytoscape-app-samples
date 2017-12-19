package org.cytoscape.legend;

import java.awt.event.ActionEvent;

import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.swing.CytoPanel;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.application.swing.CytoPanelState;


public class LegendAction extends AbstractCyAction {

	private static final long serialVersionUID = 1L;
	private CySwingApplication desktopApp;
	private final CytoPanel cytoPanelWest;
	private LegendPanel legendPanel;
	
	public LegendAction(CySwingApplication desktop, LegendPanel myPanel){
		super("Legend Panel");
		setPreferredMenu("Tools");

		desktopApp = desktop;
		cytoPanelWest = this.desktopApp.getCytoPanel(CytoPanelName.WEST);
		legendPanel = myPanel;
	}
	
	/**
	 *  actionPerformed(ActionEvent e)
	 *
	 * @param e - The event record provide the command name, source, key modifiers, etc.
	 */
	public void actionPerformed(ActionEvent e) {
		// If the state of the cytoPanelWest is HIDE, show it
		if (cytoPanelWest.getState() == CytoPanelState.HIDE) 
			cytoPanelWest.setState(CytoPanelState.DOCK);

		// Select my panel
		int index = cytoPanelWest.indexOfComponent(legendPanel);
		if (index >= 0)
			cytoPanelWest.setSelectedIndex(index);
	}

}
