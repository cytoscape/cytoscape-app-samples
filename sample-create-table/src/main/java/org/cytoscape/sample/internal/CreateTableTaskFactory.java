package org.cytoscape.sample.internal;

import org.cytoscape.model.CyTableFactory;
import org.cytoscape.task.edit.MapTableToNetworkTablesTaskFactory;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class CreateTableTaskFactory extends AbstractTaskFactory {
	
	private CyTableFactory tableFactory;
	private MapTableToNetworkTablesTaskFactory mapNetworkAttrTF;
	
	public CreateTableTaskFactory(CyTableFactory tableFactory,
			MapTableToNetworkTablesTaskFactory mapNetworkAttrTF){
		
		this.tableFactory = tableFactory;

	}
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new CreateTableTask(tableFactory, mapNetworkAttrTF));
	}

}
