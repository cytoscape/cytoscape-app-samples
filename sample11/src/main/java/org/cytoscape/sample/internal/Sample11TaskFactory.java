package org.cytoscape.sample.internal;

import org.cytoscape.model.CyTableFactory;
import org.cytoscape.task.table.MapNetworkAttrTaskFactory;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample11TaskFactory extends AbstractTaskFactory {
	
	private CyTableFactory tableFactory;
	private MapNetworkAttrTaskFactory mapNetworkAttrTF;
	
	public Sample11TaskFactory(CyTableFactory tableFactory,
			MapNetworkAttrTaskFactory mapNetworkAttrTF){
		
		this.tableFactory = tableFactory;

	}
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new CreateTableTask(tableFactory, mapNetworkAttrTF));
	}

}
