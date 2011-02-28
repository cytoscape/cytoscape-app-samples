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

public class AddSubmenuAction extends AbstractCyAction {

	private CySwingApplication desktopApp;

	public AddSubmenuAction(CyApplicationManager appMgr, CySwingApplication desktopApp){
		// Add a menu item -- File->Import->sample04
		super("sample04...", appMgr);
		setPreferredMenu("File.Import");
		//setMenuGravity(2.0f);
		
		this.desktopApp = desktopApp;
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this.desktopApp.getJFrame(), "My sub menuitem is clicked", "My message", 
				JOptionPane.INFORMATION_MESSAGE);
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
