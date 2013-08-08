package org.cytoscape.sample.internal;

import org.cytoscape.model.CyTableFactory;
import org.cytoscape.task.edit.MapTableToNetworkTablesTaskFactory;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class CreateTableTaskFactory extends AbstractTaskFactory {
	
	private CyTableFactory tableFactory;
	private MapTableToNetworkTablesTaskFactory mapTableToNetworkTablesTaskFactory;
	
	public CreateTableTaskFactory(CyTableFactory tableFactory,
			MapTableToNetworkTablesTaskFactory mapTableToNetworkTablesTaskFactory){
		this.tableFactory = tableFactory;
		this.mapTableToNetworkTablesTaskFactory = mapTableToNetworkTablesTaskFactory;
	}
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new CreateTableTask(tableFactory, mapTableToNetworkTablesTaskFactory));
	}

}
