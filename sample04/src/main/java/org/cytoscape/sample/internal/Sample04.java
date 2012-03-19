package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;

import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import javax.swing.JOptionPane;

public class Sample04 extends AbstractCyAction {

	private CySwingApplication desktopApp;

	public Sample04(CySwingApplication desktopApp){
		// Add a sub-menu item -- Apps->Sample04->sample04
		super("sample04...");
		setPreferredMenu("Apps.Sample04");
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
}
