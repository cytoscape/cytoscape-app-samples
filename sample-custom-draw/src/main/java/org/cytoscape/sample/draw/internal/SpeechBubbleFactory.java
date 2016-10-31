package org.cytoscape.sample.draw.internal;

import java.util.Map;

import javax.swing.Icon;
import javax.swing.JComponent;

import org.cytoscape.view.presentation.customgraphics.CyCustomGraphics2;
import org.cytoscape.view.presentation.customgraphics.CyCustomGraphics2Factory;

public class SpeechBubbleFactory implements CyCustomGraphics2Factory<SpeechBubbleLayer> {

	@Override
	public String getId() {
		return SpeechBubbleCustomGraphics.FACTORY_ID;
	}

	@Override
	public String getDisplayName() {
		return SpeechBubbleCustomGraphics.DISPLAY_NAME;
	}

	/**
	 * This is the icon that shows in the tab, return null to show display name in the tab instead.
	 */
	@Override
	public Icon getIcon(int width, int height) {
		return null; // Use Display Name instead of an icon.
	}

	@Override
	public CyCustomGraphics2<SpeechBubbleLayer> getInstance(String input) {
		return new SpeechBubbleCustomGraphics(input);
	}

	@Override
	public CyCustomGraphics2<SpeechBubbleLayer> getInstance(CyCustomGraphics2<SpeechBubbleLayer> customGraphics) {
		return new SpeechBubbleCustomGraphics(customGraphics);
	}

	@Override
	public CyCustomGraphics2<SpeechBubbleLayer> getInstance(Map<String, Object> properties) {
		return new SpeechBubbleCustomGraphics(properties);
	}

	@Override
	public Class<? extends CyCustomGraphics2<SpeechBubbleLayer>> getSupportedClass() {
		return SpeechBubbleCustomGraphics.class;
	}

	@Override
	public String toString() {
		return getDisplayName();
	}
	
	@Override
	public JComponent createEditor(CyCustomGraphics2<SpeechBubbleLayer> customGraphics) {
		return new SpeechBubbleEditor((SpeechBubbleCustomGraphics)customGraphics);
	}
}
