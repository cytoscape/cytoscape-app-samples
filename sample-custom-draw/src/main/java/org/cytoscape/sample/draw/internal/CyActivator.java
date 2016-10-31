package org.cytoscape.sample.draw.internal;

import java.util.Properties;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.view.presentation.customgraphics.CyCustomGraphics2Factory;
import org.osgi.framework.BundleContext;


/**
 * This sample App adds a "Speech Bubble" custom graphic.
 * <br><br>
 * 
 * How to use:
 * <ul>
 * <li>Go to the Style tab in the Control Panel.</li>
 * <li>Click the Properties combo box and select Show All.</li>
 * <li>Click one of the Custom Graphics properties.</li>
 * <li>Select the Speech Bubble tab in the dialog, enter some text.</li>
 * <li>Click the corresponding Custom Graphics Position property.</li>
 * <li>Move the position of the bubble to be next to the node.</li>
 * <ul>
 */
public class CyActivator extends AbstractCyActivator {

	
	private static String GROUP_TAB_NAME = "Speech Bubble";
	
	@Override
	public void start(BundleContext bc) throws Exception {

		// register custom graphics factory
		Properties factoryProps = new Properties();
		factoryProps.setProperty(CyCustomGraphics2Factory.GROUP, GROUP_TAB_NAME); // add a new tab
		SpeechBubbleFactory customGraphicsFactory = new SpeechBubbleFactory();
		registerService(bc, customGraphicsFactory, CyCustomGraphics2Factory.class, factoryProps);
		
	}

}
