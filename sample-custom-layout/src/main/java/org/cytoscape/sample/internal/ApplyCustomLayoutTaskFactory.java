package org.cytoscape.sample.internal;

import java.util.HashMap;
import java.util.Map;

import org.cytoscape.task.NetworkViewTaskFactory;
import org.cytoscape.view.layout.CyLayoutAlgorithm;
import org.cytoscape.view.layout.CyLayoutAlgorithmManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TunableSetter;

/**
 * Applies CustomLayout to the given CyNetworkView with specific Tunable
 * parameters.
 */
public class ApplyCustomLayoutTaskFactory implements NetworkViewTaskFactory {
	private CyLayoutAlgorithmManager layoutManager;
	private TunableSetter tunableSetter;

	public ApplyCustomLayoutTaskFactory(CyLayoutAlgorithmManager layoutManager, TunableSetter tunableSetter) {
		this.layoutManager = layoutManager;
		this.tunableSetter = tunableSetter;
	}
	
	public TaskIterator createTaskIterator(CyNetworkView view) {
		// Get an instance of the layout.  We usually won't know at runtime
		// what the implementation class is so we won't cast it to anything.
		CyLayoutAlgorithm layout = layoutManager.getLayout("customLayout");
		
		// Create a new context for the layout so we can configure the settings
		// without changing the user's defaults.
		Object context = layout.createLayoutContext();
		
		// Use TunableSetter to change the values on the Tunable fields on
		// the context object (in this case, MyLayoutContext).  These values
		// get applied when the tasks are run.
		Map<String, Object> tunableValues = new HashMap<String, Object>();
		tunableValues.put("XRange", 50);
		tunableValues.put("YRange", 50);
		tunableSetter.applyTunables(context, tunableValues);

		String layoutAttribute = null;
		return layout.createTaskIterator(view, context, CyLayoutAlgorithm.ALL_NODE_VIEWS, layoutAttribute);
	}
	
	public boolean isReady(CyNetworkView view) {
		return view != null;
	};
}
