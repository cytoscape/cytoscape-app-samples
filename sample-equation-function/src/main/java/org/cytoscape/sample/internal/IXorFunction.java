package org.cytoscape.sample.internal;


import org.cytoscape.equations.AbstractFunction;
import org.cytoscape.equations.ArgDescriptor;
import org.cytoscape.equations.ArgType;
import org.cytoscape.equations.FunctionUtil;


public class IXorFunction extends AbstractFunction {
	public IXorFunction() {
		super(new ArgDescriptor[] {
				new ArgDescriptor(ArgType.INT, "arg1", "A quantity that can be converted to an integer."),
				new ArgDescriptor(ArgType.INT, "arg2", "A quantity that can be converted to an integer."),
			});
	}

	/**
	 *  Used to parse the function string.  This name is treated in a case-insensitive manner!
	 *  @returns the name by which you must call the function when used in an attribute equation.
	 */
	public String getName() { return "IXOR"; }

	/**
	 *  Used to provide help for users.
	 *  @returns a description of what this function does
	 */
	public String getFunctionSummary() { return "Returns an integer value that is the exclusive-or of 2 other integer values."; }

	public Class getReturnType() { return Long.class; }

	/**
	 *  @param args the function arguments which must be two objects of type Long
	 *  @returns the result of the function evaluation which is the exclusive-or of the bits of the 2 arguments
	 */
	public Object evaluateFunction(final Object[] args) {
		long arg1;
		try {
			arg1 = FunctionUtil.getArgAsLong(args[0]);
		} catch (final Exception e) {
			throw new IllegalArgumentException("IXOR: can't convert the 1st argument to an integer.");
		}

		long arg2;
		try {
			arg2 = FunctionUtil.getArgAsLong(args[0]);
		} catch (final Exception e) {
			throw new IllegalArgumentException("IXOR: can't convert the 2nd argument to an integer.");
		}

		final long result = arg1 ^ arg2;
		return (Long)result;
	}
}
