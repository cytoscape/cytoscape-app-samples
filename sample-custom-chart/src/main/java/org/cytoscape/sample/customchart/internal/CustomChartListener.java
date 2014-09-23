package org.cytoscape.sample.customchart.internal;

import java.util.Map;

import org.cytoscape.view.presentation.customgraphics.CyCustomGraphics2Factory;


/**
 * OSGi service listener that acquires a reference to the custom graphics service we want.
 */
public class CustomChartListener {

	private static final String FACTORY_ID = "org.cytoscape.PieChart";
	
	private CyCustomGraphics2Factory<?> factory;

	
	public void addCustomGraphicsFactory(CyCustomGraphics2Factory<?> factory, Map<Object,Object> serviceProps) {
		if(FACTORY_ID.equals(factory.getId())) {
			this.factory = factory;
		}
	}
	
	public void removeCustomGraphicsFactory(CyCustomGraphics2Factory<?> factory, Map<Object,Object> serviceProps) {
		this.factory = null;
	}
	
	public CyCustomGraphics2Factory<?> getFactory() {
		return factory;
	}
	
	
}
