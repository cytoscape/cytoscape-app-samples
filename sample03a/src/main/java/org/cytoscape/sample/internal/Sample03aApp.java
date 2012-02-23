package org.cytoscape.sample.internal;

import org.cytoscape.app.AbstractCyApp;
import org.cytoscape.app.CyAppAdapter;


/**
 * An implementation of CyPluginAdapter
 */
public class Sample03aApp extends AbstractCyApp {
	
	public Sample03aApp(CyAppAdapter a){
		super(a);
		
		a.getCySwingApplication().addAction(new Sample03aAction());
	}
}
