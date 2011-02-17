package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.swing.GUITaskManager;

public class Sample10Action extends AbstractCyAction {

	private GUITaskManager taskMgr;
	private CyApplicationManager appMgr;
	
	public Sample10Action(CyApplicationManager appMgr, CySwingApplication desktopApp,
			GUITaskManager taskMgr){
		super("sample10", appMgr);
		setPreferredMenu("Plugins");

		this.taskMgr = taskMgr;
		this.appMgr = appMgr;
	}
	
	public void actionPerformed(ActionEvent e) {
		CyNetworkView view = this.appMgr.getCurrentNetworkView();
		if (view == null){
			return;
		}
		
		double scale = 2.0;
		
		ZoomTaskFactory factory = new ZoomTaskFactory(view, scale);
		this.taskMgr.execute(factory);	
	}
}
