package org.cytoscape.legend;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.service.util.CyServiceRegistrar;

public class LegendPanel extends JPanel implements CytoPanelComponent {
	
	private static final long serialVersionUID = 8292806967891823933L;

	CyServiceRegistrar registrar;
	LegendController controller;
	
	public LegendPanel(CyServiceRegistrar reg, LegendController ctrl) {
		registrar = reg;
		controller = ctrl;
		 
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new JLabel("Legend"));
		add(new JLabel("Use these controls to customize you legend"));
		JCheckBox horiz = new JCheckBox("Horizontal Orientation");
		ActionListener listener = new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.out.println("check on " + e.getActionCommand());
			}
		};
		
		ActionListener listener2 = new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) { controller.createLegend(); }
		};
		
		horiz.addActionListener(listener);
		add(horiz);
		JCheckBox showShape = new JCheckBox("Include Node Shape");
		JCheckBox showColor = new JCheckBox("Include Node Fill Color");
		JCheckBox showBorder = new JCheckBox("Include Node Border Color");
		JCheckBox showEdgeAttributes = new JCheckBox("Show Edge Color");
		JCheckBox showEdge = new JCheckBox("Show Edge Line Type");

		showShape.addActionListener(listener);
		showColor.addActionListener(listener);
		showBorder.addActionListener(listener);
		showEdgeAttributes.addActionListener(listener);
		showEdge.addActionListener(listener);
		
		add(showShape);
		add(showColor);
		add(showBorder);
		add(showEdgeAttributes);
		add(showEdge);

		JButton adder = new JButton("Add Legend");
		adder.addActionListener(listener2);
		add(adder);
		setVisible(true);
	}


	public Component getComponent() 				{		return this;	}
	public CytoPanelName getCytoPanelName() 		{		return CytoPanelName.WEST;	}
	public String getTitle() 					{		return "Legend Panel";	}
	public Icon getIcon() 						{		return null;	}

}
