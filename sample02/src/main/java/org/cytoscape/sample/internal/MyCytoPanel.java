package org.cytoscape.sample.internal;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JPanel;
import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import javax.swing.JLabel;

public class MyCytoPanel extends JPanel implements CytoPanelComponent {
	public MyCytoPanel() {
		
		JLabel lbXYZ = new JLabel("This is my Panel");
		
		this.add(lbXYZ);
		this.setVisible(true);
	}
	
	@Override
	public Component getComponent() {
		return this;
	}

	@Override
	public CytoPanelName getCytoPanelName() {
		return CytoPanelName.WEST;
	}

	@Override
	public String getTitle() {
		return "MyPanel";
	}

	@Override
	public Icon getIcon() {
		return null;
	}
}
