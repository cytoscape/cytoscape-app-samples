package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.model.CyTable;


public class DeleteAttributeTask extends AbstractTask {

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
		
		String columnName = "MyAttributeName";

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
