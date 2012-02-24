package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;

import org.cytoscape.application.swing.AbstractCyAction;

public class Sample16 extends AbstractCyAction {
	
	public Sample16(){
		// Add a menu item -- Apps->sample16
		super("sample16");
		setPreferredMenu("Apps");

		//this.desktopApp = desktopApp;
		
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {

		System.out.println("Menu item Sample16 is clicked");
	}

}
