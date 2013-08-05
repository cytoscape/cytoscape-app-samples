package org.cytoscape.sample.internal;

import org.osgi.framework.BundleContext;
import org.cytoscape.equations.EquationCompiler;
import org.cytoscape.equations.Interpreter;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		
		//MyNodeViewTaskFactory myNodeViewTaskFactory = new MyNodeViewTaskFactory();
		
		
//		Properties myNodeViewTaskFactoryProps = new Properties();
//		myNodeViewTaskFactoryProps.setProperty("title","Double node size");
		//registerService(bc,myNodeViewTaskFactory,NodeViewTaskFactory.class, myNodeViewTaskFactoryProps);

		// Get service reference
		
		EquationCompiler eqCompilerRef = getService(bc,EquationCompiler.class);
		Interpreter interpreterRef =  getService(bc,Interpreter.class);
		

		Sample23 sample23 = new Sample23(eqCompilerRef, interpreterRef);
		
	}
}

