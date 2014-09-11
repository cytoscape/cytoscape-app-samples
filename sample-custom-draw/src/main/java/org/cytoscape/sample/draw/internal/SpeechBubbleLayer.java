package org.cytoscape.sample.draw.internal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import org.cytoscape.model.CyIdentifiable;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.customgraphics.CustomGraphicLayer;
import org.cytoscape.view.presentation.customgraphics.Cy2DGraphicLayer;


public class SpeechBubbleLayer implements Cy2DGraphicLayer {

	private final Rectangle2D bounds;
	private final String text;
	

	public SpeechBubbleLayer(String text) {
		this.bounds = new Rectangle(0, 0, 100, 100); // initial bounds can be anything you like
		this.text = text;
	}
	
	private SpeechBubbleLayer(String text, Rectangle2D bounds) {
		this.bounds = bounds;
		this.text = text;
		
	}
	
	@Override
	public Rectangle2D getBounds2D() {
		return bounds;
	}

	@Override
	public Paint getPaint(Rectangle2D bounds) {
		return null; // not used for a Cy2DGraphicLayer
	}

	
	/**
	 * Returns a new layer with the bounds transformed according to the given AffineTransform.
	 * 
	 * Usually the bounds are scaled to be the same height and width as the node and translated 
	 * according to the "Custom Graphics Position" property.
	 */
	@Override
	public CustomGraphicLayer transform(AffineTransform transform) {
		return new SpeechBubbleLayer(text, transform.createTransformedShape(bounds).getBounds2D());
	}

	
	/**
	 * This method renders the speech bubble by drawing directly on the given Graphics2D instance.
	 */
	@Override
	public void draw(Graphics2D g, Shape nodeShape, CyNetworkView networkView, View<? extends CyIdentifiable> view) {
		// Make the bubble slightly larger than the node
		double bHeight = bounds.getHeight() * 2;
		double bWidth = bHeight * 2;
		double bx = -bWidth / 2 + bounds.getX();
		double by = -bHeight / 2 + bounds.getY();
		
		Point2D tip = getTip(nodeShape);
		
		Shape speechBubble = SpeechBubble.create(bx, by, bWidth, bHeight, tip.getX(), tip.getY());
		
		g.setColor(Color.DARK_GRAY);
		drawText(g, bx + 5, by + 5, bWidth - 10); 
		g.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.draw(speechBubble);
	}
	
	
	/**
	 * Draws the text into the speech bubble.
	 * Note if the text doesn't fit it will spill downwards.
	 */
	private void drawText(Graphics2D g, double x, double y, double width) {
		AttributedString as = new AttributedString(text);
		AttributedCharacterIterator charIter = as.getIterator();
		
		FontRenderContext fontRenderContext = g.getFontRenderContext();
		LineBreakMeasurer measurer = new LineBreakMeasurer(charIter, fontRenderContext);
		
		while (measurer.getPosition() < charIter.getEndIndex()) {
			TextLayout textLayout = measurer.nextLayout((float)width);
			y += textLayout.getAscent();
			textLayout.draw(g, (float)x, (float)y);
			y += textLayout.getDescent() + textLayout.getLeading();
		}
	}
	
	
	/**
	 * Computes the location of the tip of the speech bubble tail based on location of the
	 * bounds relative to the location of the node.
	 */
	private Point2D getTip(Shape nodeShape) {
		Rectangle2D nodeBounds = nodeShape.getBounds2D();
		
		double halfHeight = nodeBounds.getHeight()/2;
		boolean above = bounds.getY() < -halfHeight;
		boolean below = bounds.getY() > halfHeight;
		
		if(above || below)
			return new Point2D.Double(0, above ? -halfHeight : halfHeight);
		else
			return new Point2D.Double((bounds.getX() < 0 ? -1 : 1) * nodeBounds.getWidth()/2, 0);
	}
	
}