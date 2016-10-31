package org.cytoscape.sample.draw.internal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.cytoscape.model.CyIdentifiable;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.customgraphics.CyCustomGraphics2;

/**
 * Creates Layer objects and stores properties that are set by the editor.
 */
public class SpeechBubbleCustomGraphics implements CyCustomGraphics2<SpeechBubbleLayer> {

	public static final String FACTORY_ID = "org.cytoscape.sample.SpeechBubble";
	public static final String DISPLAY_NAME = "Speech Bubble";
	
	// The property key for accessing the text that the user entered
	private static final String PROPERTY_TEXT = "org.cytoscape.sample.draw.internal.text";
	
	
	private final Map<String, Object> properties;
	
	private Long id;
	private String displayName = DISPLAY_NAME;
	private int height = 50;
	private int width = 50;
	private float fitRatio = 1.0f;
	
	private BufferedImage icon = null; 

	
	
	/**
	 * Initialize from properties.
	 */
	public SpeechBubbleCustomGraphics(Map<String, Object> properties) {
		this.properties = properties;
	}

	/**
	 * Copy constructor.
	 */
	public SpeechBubbleCustomGraphics(CyCustomGraphics2<SpeechBubbleLayer> other) {
		this(other.getProperties());
	}
	
	/**
	 * Initialize by parsing properties from a serialized String.
	 */
	public SpeechBubbleCustomGraphics(String serializedProperties) {
		this.properties = parseProperties(serializedProperties);
	}

	
	
	@Override
	public List<SpeechBubbleLayer> getLayers(CyNetworkView networkView, View<? extends CyIdentifiable> grView) {
		// a custom graphic may be composed of several layers, we only need one layer
		SpeechBubbleLayer layer = new SpeechBubbleLayer(getText());
		return Collections.singletonList(layer);
	}

	
	@Override
	public Image getRenderedImage() {
		// creates the icon graphic that can be seen in the style properties pane
		if(icon == null) {
			Rectangle rect = new Rectangle(0, 0, 100, 100);
			icon = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = icon.createGraphics();
			
			Shape speechBubble = SpeechBubble.create(0, 0, rect.width, rect.height/4*3, 20, rect.height);
			
			g2d.setColor(Color.GRAY.brighter());
			g2d.fill(speechBubble);
			g2d.setColor(Color.GRAY.darker());
			g2d.draw(speechBubble);
		}
		return icon;
	}

	
	
	public void setText(String text) {
		properties.put(PROPERTY_TEXT, text);
	}
	
	public String getText() {
		return (String) properties.get(PROPERTY_TEXT);
	}
	
	
	private Map<String, Object> parseProperties(String input) {
		Map<String,Object> props = new HashMap<String, Object>();
		Properties loader = new Properties();
		try {
			loader.load(new ByteArrayInputStream(input.getBytes()));
		} catch (IOException e) {
			return props;
		}
		
		for(String name : loader.stringPropertyNames()) {
			props.put(name, loader.getProperty(name));
		}
		
		return props;
	}
	
	@Override
	public String getSerializableString() {
		return toSerializableString();
	}

	@Override
	public String toSerializableString() {
		Properties exporter = new Properties();
		for(String name : properties.keySet()) {
			exporter.put(name, properties.get(name));
		}
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			exporter.store(out, "");
		} catch (IOException e) { }
		
		
		return new String(out.toByteArray());
	}
	
	
	@Override
	public Map<String, Object> getProperties() {
		return properties;
	}

	
	
	@Override
	public Long getIdentifier() {
		return id;
	}

	@Override
	public void setIdentifier(Long id) {
		this.id = id;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public float getFitRatio() {
		return fitRatio;
	}

	@Override
	public void setFitRatio(float ratio) {
		this.fitRatio = ratio;
	}


}
 