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

public classLoadAttributeDataAction extends AbstractCyAction {

	private CySwingApplication desktopApp;

	public classLoadAttributeDataAction(CyApplicationManager appMgr, CySwingApplication desktopApp){
		super("sample11...", appMgr);
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
