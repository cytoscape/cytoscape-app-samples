package org.cytoscape.sample.internal;


import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;

// This class is from 3rd party jar -- colt
import cern.jet.stat.*;

public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		
		double d = Probability.normal(0.1);
		
		System.out.println("\nUse the class from 3rd party jar -- colt: d = "+ d);

	}
}

