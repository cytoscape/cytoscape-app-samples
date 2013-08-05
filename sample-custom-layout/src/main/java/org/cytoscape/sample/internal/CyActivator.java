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
		// MyLayout service
		UndoSupport undo = getService(bc, UndoSupport.class);
		MyLayout myLayout = new MyLayout(undo);
		
		Properties myLayoutProps = new Properties();
		myLayoutProps.setProperty(PREFERRED_MENU, "My Layouts");
		registerService(bc, myLayout, CyLayoutAlgorithm.class, myLayoutProps);

		// ApplyMyLayoutTaskFactory service
		CyLayoutAlgorithmManager layoutManager = getService(bc, CyLayoutAlgorithmManager.class);
		TunableSetter tunableSetter = getService(bc, TunableSetter.class);
		ApplyMyLayoutTaskFactory applyLayoutTaskFactory = new ApplyMyLayoutTaskFactory(layoutManager, tunableSetter);
		
		Properties applyLayoutProperties = new Properties();
		applyLayoutProperties.setProperty(PREFERRED_MENU, "Apps");
		applyLayoutProperties.setProperty(TITLE, "Apply MyLayout");
		registerService(bc, applyLayoutTaskFactory, NetworkViewTaskFactory.class, applyLayoutProperties);
	}
}

