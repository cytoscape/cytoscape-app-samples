package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
import org.cytoscape.model.CyTable;


public class DeleteAttributeTask extends AbstractTask {

	@Tunable(description="Column name to delete")
	public String columnName = "MyAttributeName";
	private CyNetwork network;
	
	public DeleteAttributeTask(CyNetwork network){
		this.network = network;
	}
	
	
	public void run(TaskMonitor monitor) {
		if (network == null){
			System.out.println("There is no network!");
			return;
		}
		
		CyTable nodeTable = network.getDefaultNodeTable();
		
		if(nodeTable.getColumn(columnName)!= null){
			nodeTable.deleteColumn(columnName);			
			System.out.println("Column "+ columnName + " is deleted");
		}
		else {
			System.out.println("No such column!");
		}
	} 
	
	
	public void cancel() {
		cancelled = true;
	}
}
