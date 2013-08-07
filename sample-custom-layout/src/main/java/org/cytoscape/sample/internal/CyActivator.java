package org.cytoscape.sample.internal;

import static org.cytoscape.work.ServiceProperties.PREFERRED_MENU;
import static org.cytoscape.work.ServiceProperties.TITLE;

import java.util.Properties;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;
import org.cytoscape.view.layout.CyLayoutAlgorithm;
import org.cytoscape.view.layout.CyLayoutAlgorithmManager;
import org.cytoscape.work.TunableSetter;
import org.cytoscape.work.undo.UndoSupport;
import org.osgi.framework.BundleContext;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		// CustomLayout service
		UndoSupport undo = getService(bc, UndoSupport.class);
		CustomLayout customLayout = new CustomLayout(undo);
		
		Properties customLayoutProps = new Properties();
		customLayoutProps.setProperty(PREFERRED_MENU, "Custom Layouts");
		registerService(bc, customLayout, CyLayoutAlgorithm.class, customLayoutProps);

		// ApplyCustomLayoutTaskFactory service
		CyLayoutAlgorithmManager layoutManager = getService(bc, CyLayoutAlgorithmManager.class);
		TunableSetter tunableSetter = getService(bc, TunableSetter.class);
		ApplyCustomLayoutTaskFactory applyLayoutTaskFactory = new ApplyCustomLayoutTaskFactory(layoutManager, tunableSetter);
		
		Properties applyCustomLayoutProperties = new Properties();
		applyCustomLayoutProperties.setProperty(PREFERRED_MENU, "Apps.Samples");
		applyCustomLayoutProperties.setProperty(TITLE, "Apply Custom Layout");
		registerService(bc, applyLayoutTaskFactory, NetworkViewTaskFactory.class, applyCustomLayoutProperties);
	}
}

