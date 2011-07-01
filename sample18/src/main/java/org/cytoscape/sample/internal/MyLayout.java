package org.cytoscape.sample.internal;

import org.cytoscape.view.layout.AbstractLayoutAlgorithm;
import org.cytoscape.view.layout.CyLayoutAlgorithmManager;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.Tunable;
import org.cytoscape.work.TunableValidator;
import org.cytoscape.work.TunableValidator.ValidationState;
import org.cytoscape.work.undo.UndoSupport;

public class MyLayout extends AbstractLayoutAlgorithm implements TunableValidator {

	
	@Tunable(description="Shift X Range")
	public int XRange = 100; // Default value
	@Tunable(description="Shift Y Range")
	public int YRange= 1000;// Default value

	/**
	 * Creates a new MyLayout object.
	 */
	public MyLayout(UndoSupport un) {
		super(un,"computer name","human name",true);
	}
	
	public ValidationState getValidationState(final Appendable errMsg) {
		if (XRange <= 100){
			return ValidationState.OK;			
		}
		try {
			errMsg.append("Xrange must not exceed 100!");
		} catch (final Exception e) {
			/* Intentionally ignored! */
		}
		return ValidationState.INVALID;
	}

	public TaskIterator getTaskIterator() {
		return new TaskIterator(new MyLayoutTask(networkView, getName(), selectedOnly, staticNodes, XRange, YRange));
	}

}
