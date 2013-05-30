package org.cytoscape.sample.internal;

import org.cytoscape.equations.EquationCompiler;
import org.cytoscape.equations.Interpreter;
import org.cytoscape.equations.EquationParser;


public class Sample23 {

	public Sample23(EquationCompiler eqCompilerRef, Interpreter interpreterRef){
		final EquationParser theParser = eqCompilerRef.getParser();
		theParser.registerFunction(new IXor());
	}
}
