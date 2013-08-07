package org.cytoscape.sample.internal;

import org.cytoscape.equations.EquationCompiler;
import org.cytoscape.equations.EquationParser;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		EquationCompiler eqCompilerRef = getService(bc,EquationCompiler.class);
		final EquationParser theParser = eqCompilerRef.getParser();
		theParser.registerFunction(new IXorFunction());
	}
}

