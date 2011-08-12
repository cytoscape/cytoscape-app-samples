package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
import org.cytoscape.model.CyTable;


public class DeleteAttributeTask extends AbstractTask {

	@Tunable(description="Column name to delete")
	public String columnName = "MyAttributeName";
	
	private CyApplicationManager appMgr;
	public DeleteAttributeTask(CyApplicationManager appMgr){
		this.appMgr = appMgr;	
	}
	
	
	public void run(TaskMonitor monitor) {
		if (this.appMgr.getCurrentNetworkView() == null){
			System.out.println("There is no network view!");
			return;
		}
		
		CyNetwork currNet = this.appMgr.getCurrentNetworkView().getModel();
		CyTable nodeTable = currNet.getDefaultNodeTable();
		
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
