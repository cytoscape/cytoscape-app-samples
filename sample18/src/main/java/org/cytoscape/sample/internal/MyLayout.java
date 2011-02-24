package org.cytoscape.sample.internal;

import org.cytoscape.view.layout.AbstractLayout;
import org.cytoscape.view.layout.CyLayouts;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.Tunable;
import org.cytoscape.work.TunableValidator;
import org.cytoscape.work.undo.UndoSupport;

public class MyLayout extends AbstractLayout implements TunableValidator {

	
	@Tunable(description="Shift X Range")
	public int XRange = 100; // Default value
	@Tunable(description="Shift Y Range")
	public int YRange= 1000;// Default value

	/**
	 * Creates a new MyLayout object.
	 */
	public MyLayout(UndoSupport un) {
		super(un);
	}
	
	public boolean tunablesAreValid(final Appendable errMsg) {
		if (XRange <= 100){
			return true;			
		}
		try {
			errMsg.append("Xrange must not exceed 100!");
		} catch (final Exception e) {
			/* Intentionally ignored! */
		}
		return false;
	}

	public TaskIterator getTaskIterator() {
		return new TaskIterator(new MyLayoutTask(networkView, getName(), selectedOnly, staticNodes, XRange, YRange));
	}

	/**
	 *  DOCUMENT ME!
	 *
	 * @return  DOCUMENT ME!
	 */
	public String getName() {
		return CyLayouts.DEFAULT_LAYOUT_NAME;
	}

	/**
	 *  DOCUMENT ME!
	 *
	 * @return  DOCUMENT ME!
	 */
	public String toString() {
		return "My First Layout Algorithm";
	}

}
