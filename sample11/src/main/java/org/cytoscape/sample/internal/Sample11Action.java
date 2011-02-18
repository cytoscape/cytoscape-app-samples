package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.session.CyApplicationManager;

import org.cytoscape.work.swing.GUITaskManager;

import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyTableFactory;

public class Sample11Action extends AbstractCyAction {

	private CyTableFactory tableFactory;
	private GUITaskManager taskMgr;
	private CyApplicationManager appMgr;
	private CyNetworkManager netMgr;

	public Sample11Action(CyApplicationManager appMgr, GUITaskManager taskMgr, 
			CyNetworkManager netMgr, CyTableFactory tableFactory){
		super("sample11...", appMgr);
		setPreferredMenu("Plugins");

		this.appMgr = appMgr;
		this.taskMgr = taskMgr;
		this.netMgr = netMgr;
		this.tableFactory = tableFactory;
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {
				
		ImportAttributeTask task = new ImportAttributeTask(appMgr, netMgr, tableFactory);
		ImportAttributeTaskFactory factory = new ImportAttributeTaskFactory(task);
		this.taskMgr.execute(factory);
	}
}

