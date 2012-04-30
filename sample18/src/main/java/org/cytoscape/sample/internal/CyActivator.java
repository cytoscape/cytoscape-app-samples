package org.cytoscape.sample.internal;

import org.cytoscape.sample.internal.MyLayout;

import org.cytoscape.view.layout.CyLayoutAlgorithm;
import org.cytoscape.work.undo.UndoSupport;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		
		UndoSupport undo = getService(bc, UndoSupport.class);

		MyLayout myLayout = new MyLayout(undo);
		
		
		Properties myLayoutProps = new Properties();
		myLayoutProps.setProperty("preferredMenu","My Layouts");
		registerService(bc,myLayout,CyLayoutAlgorithm.class, myLayoutProps);

		

	}
}

