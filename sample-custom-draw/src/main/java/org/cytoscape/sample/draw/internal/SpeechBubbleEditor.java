package org.cytoscape.sample.draw.internal;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 * Creates a tab in the custom graphics dialog that is used to
 * enter the speech bubble text.
 */
public class SpeechBubbleEditor extends JPanel {

	private static final long serialVersionUID = -5336685614189693051L;
	
	private SpeechBubbleCustomGraphics customGraphics;
	
	public SpeechBubbleEditor(SpeechBubbleCustomGraphics customGraphics) {
		this.customGraphics = customGraphics;
		init();
	}

	private void init() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setOpaque(false);
		
		JLabel label = new JLabel("Text");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		add(label);
		
		final JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setMaximumSize(new Dimension(250, 100));
		scrollPane.setPreferredSize(new Dimension(250, 100));
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(scrollPane);
		
		textPane.setText(customGraphics.getText());
		
		textPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				customGraphics.setText(textPane.getText());
			}
		});
	}

}
