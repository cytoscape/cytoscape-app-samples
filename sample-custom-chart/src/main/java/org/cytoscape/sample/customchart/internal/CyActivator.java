package org.cytoscape.sample.customchart.internal;

import java.util.Properties;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.view.presentation.customgraphics.CyCustomGraphics2Factory;
import org.cytoscape.view.presentation.property.values.CyColumnIdentifierFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.ServiceProperties;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext bc) throws Exception {
		
		final CyApplicationManager applicationManager = getService(bc, CyApplicationManager.class);
		final VisualMappingManager visualMappingManager = getService(bc, VisualMappingManager.class);
		
		final CyColumnIdentifierFactory columnIdFactory = getService(bc, CyColumnIdentifierFactory.class);
		
		// Only way to get the custom graphics factory is to use a service listener.
		final CustomChartListener customChartManager = new CustomChartListener();
		registerServiceListener(bc, customChartManager, "addCustomGraphicsFactory", "removeCustomGraphicsFactory", CyCustomGraphics2Factory.class);
		
		// Create a task that is shown in the "Apps" menu.
		TaskFactory taskFactory = new AbstractTaskFactory() {
			@Override
			public TaskIterator createTaskIterator() {
				return new TaskIterator(new ChartTask(applicationManager, customChartManager, visualMappingManager, columnIdFactory));
			}
		};
		Properties props = new Properties();
		props.put(ServiceProperties.PREFERRED_MENU, ServiceProperties.APPS_MENU);
		props.put(ServiceProperties.TITLE, "Generate Edge Weight Charts...");
		registerService(bc, taskFactory, TaskFactory.class, props);
		
	}

}
