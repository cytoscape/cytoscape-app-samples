package org.cytoscape.sample.internal;

import org.cytoscape.model.CyTableFactory;
import org.cytoscape.task.edit.MapTableToNetworkTablesTaskFactory;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample11TaskFactory extends AbstractTaskFactory {
	
	private CyTableFactory tableFactory;
	private MapTableToNetworkTablesTaskFactory mapNetworkAttrTF;
	
	public Sample11TaskFactory(CyTableFactory tableFactory,
			MapTableToNetworkTablesTaskFactory mapNetworkAttrTF){
		
		this.tableFactory = tableFactory;
		this.mapNetworkAttrTF = mapNetworkAttrTF;

	}
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new CreateTableTask(tableFactory, mapNetworkAttrTF));
	}

}
