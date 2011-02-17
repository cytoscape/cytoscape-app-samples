package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;

import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.session.CyApplicationManager;
import org.cytoscape.work.swing.GUITaskManager;

public class Sample22Action extends AbstractCyAction {

	private GUITaskManager taskMgr;
	
	public Sample22Action(CyApplicationManager applicationManager, GUITaskManager taskMgr){
		
		super("sample22", applicationManager);
		setPreferredMenu("Plugins");

		this.taskMgr = taskMgr;
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @param e DOCUMENT ME!
	 */
	public void actionPerformed(ActionEvent e) {
		//
		MyTaskFactory factory = new MyTaskFactory();
		this.taskMgr.execute(factory);	
	}
	
	/**
	 *  DOCUMENT ME!
	 *
	 * @return  DOCUMENT ME!
	 */
	public boolean isInToolBar() {
		return false;
	}

	/**
	 *  DOCUMENT ME!
	 *
	 * @return  DOCUMENT ME!
	 */
	public boolean isInMenuBar() {
		return true;
	}

}
