package org.cytoscape.sample.internal;

import java.io.IOException;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.CyIdentifiable;
import org.cytoscape.model.CyTableFactory;
import org.cytoscape.task.edit.MapTableToNetworkTablesTaskFactory;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;


public class CreateTableTask extends AbstractTask {
	private static int numImports = 0;
	
	private CyTableFactory tableFactory;
	private MapTableToNetworkTablesTaskFactory mapNetworkAttrTF;
	
	public CreateTableTask(CyTableFactory tableFactory, MapTableToNetworkTablesTaskFactory mapNetworkAttrTF){
		this.tableFactory = tableFactory;
		this.mapNetworkAttrTF = mapNetworkAttrTF;
	}
	
	@Override
	public void run(TaskMonitor tm) throws IOException {
		// Step 1: create a new table
		CyTable table = tableFactory.createTable("MyAttrTable " + Integer.toString(numImports++), 
				   "name", String.class, true, true);

		// create a column for the table
		String attributeNmae = "MyAttributeName"; 
		table.createColumn(attributeNmae, Integer.class, false);
		
		// Step 2: populate the table with some data
		String[] keys = {"YLL021W","YBR170C","YLR249W"}; //map to the the "name" column
		CyRow row = table.getRow(keys[0]);
		row.set(attributeNmae, new Integer(2));

		row = table.getRow(keys[1]);
		row.set(attributeNmae, new Integer(3));

		row = table.getRow(keys[2]);
		row.set(attributeNmae, new Integer(4));

		// Step 3: pass the new table to MapNetworkAttrTask
		super.insertTasksAfterCurrentTask( mapNetworkAttrTF.createTaskIterator(table) );

	}
}
