package org.cytoscape.sample.internal;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JPanel;
import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import javax.swing.JLabel;

public class MyControlPanel extends JPanel implements CytoPanelComponent {
	
	private static final long serialVersionUID = 8292806967891823933L;


	public MyControlPanel() {
		
		JLabel lbXYZ = new JLabel("This is my Control Panel");
		
		this.add(lbXYZ);
		this.setVisible(true);
	}


	public Component getComponent() {
		return this;
	}


	public CytoPanelName getCytoPanelName() {
		return CytoPanelName.WEST;
	}


	public String getTitle() {
		return "Bundle App Panel";
	}


	public Icon getIcon() {
		return null;
	}
}
