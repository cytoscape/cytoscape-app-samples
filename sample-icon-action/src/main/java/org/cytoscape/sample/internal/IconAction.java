package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;

public class IconAction extends AbstractCyAction {

	private static final long serialVersionUID = 1L;
	private CySwingApplication desktopApp;
	
	public IconAction(CySwingApplication desktopApp){
		// Add a menu item
		super("Icon Action");
		setPreferredMenu("Apps.Samples");

		ImageIcon icon = new ImageIcon(getClass().getResource("/images/tiger.jpg"));
		ImageIcon smallIcon = new ImageIcon(getClass().getResource("/images/tiger_small.jpg"));

		// Add image icons on tool-bar and menu item
		putValue(LARGE_ICON_KEY, icon);
		putValue(SMALL_ICON, smallIcon);
		
		this.desktopApp = desktopApp;
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this.desktopApp.getJFrame(), "My image icon/menu item is clicked", "My message", 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @return  DOCUMENT ME!
	 */
	public boolean isInToolBar() {
		return true;
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
