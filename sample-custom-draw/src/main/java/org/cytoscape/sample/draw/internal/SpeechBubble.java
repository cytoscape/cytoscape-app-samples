package org.cytoscape.sample.draw.internal;

import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;


/**
 * A speech bubble is a Shape that consists of a bubble that is usually used as a
 * container for text and a tail that points at the object that the text refers to.
 */
public class SpeechBubble {

	private SpeechBubble() {
	}
	
	/**
	 * @param bubbleX the X coordinate of the upper-left corner of the bubble
	 * @param bubbleY the Y coordinate of the upper-left corner of the bubble 
	 * @param bubbleWidth the width of the bubble
	 * @param bubbleHeight the height of the bubble
	 * @param tipX the X coordinate of the tip of the tail
	 * @param tipY the Y coordinate of the tip of the tail
	 */
	public static Shape create(double bubbleX, double bubbleY, double bubbleWidth, double bubbleHeight, double tipX, double tipY) {
		Shape bubble = createBubble(bubbleX, bubbleY, bubbleWidth, bubbleHeight);
		Shape tail  = createTail(bubble, tipX, tipY);
		
		Area speechBubble = new Area(bubble);
		speechBubble.add(new Area(tail));
		
		return speechBubble;
	}
	
	
	private static Shape createBubble(double x, double y, double width, double height) {
		return new RoundRectangle2D.Double(x, y, width, height, 20, 20);
	}
	
	
	private static Shape createTail(Shape ellipse, double tipX, double tipY) {
		Rectangle2D bounds = ellipse.getBounds2D();
		
		boolean above = tipY < bounds.getY();
		boolean below = tipY > bounds.getY() + bounds.getHeight();
		
		GeneralPath path = new GeneralPath();
		
		if(above || below) {
			double topWidth = bounds.getWidth() / 4.0;
			path.moveTo(bounds.getCenterX() - topWidth, bounds.getCenterY());
			path.lineTo(tipX, tipY);
			path.lineTo(bounds.getCenterX() + topWidth, bounds.getCenterY());
		}
		else {
			double topHeight = bounds.getHeight() / 4.0;
			path.moveTo(bounds.getCenterX(), bounds.getCenterY() - topHeight);
			path.lineTo(tipX, tipY);
			path.lineTo(bounds.getCenterX(), bounds.getCenterY() + topHeight);
		}
		
		path.closePath();
		return path;
	}
}
