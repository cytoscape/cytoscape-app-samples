/*
 Copyright (c) 2006, 2007, The Cytoscape Consortium (www.cytoscape.org)

 The Cytoscape Consortium is:
 - Institute for Systems Biology
 - University of California San Diego
 - Memorial Sloan-Kettering Cancer Center
 - Institut Pasteur
 - Agilent Technologies

 This library is free software; you can redistribute it and/or modify it
 under the terms of the GNU Lesser General Public License as published
 by the Free Software Foundation; either version 2.1 of the License, or
 any later version.

 This library is distributed in the hope that it will be useful, but
 WITHOUT ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF
 MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE.  The software and
 documentation provided hereunder is on an "as is" basis, and the
 Institute for Systems Biology and the Whitehead Institute
 have no obligations to provide maintenance, support,
 updates, enhancements or modifications.  In no event shall the
 Institute for Systems Biology and the Whitehead Institute
 be liable to any party for direct, indirect, special,
 incidental or consequential damages, including lost profits, arising
 out of the use of this software and its documentation, even if the
 Institute for Systems Biology and the Whitehead Institute
 have been advised of the possibility of such damage.  See
 the GNU Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation,
 Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.
 */
package org.cytoscape.sample.internal;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.events.SetCurrentNetworkEvent;
import org.cytoscape.application.events.SetCurrentNetworkListener;
import org.cytoscape.model.CyColumn;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.CyTableManager;
import org.cytoscape.model.events.ColumnCreatedEvent;
import org.cytoscape.model.events.ColumnCreatedListener;
import org.cytoscape.model.events.ColumnDeletedEvent;
import org.cytoscape.model.events.ColumnDeletedListener;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.swing.DialogTaskManager;

public class MyWebServiceClientPanel extends JPanel implements ColumnCreatedListener, ColumnDeletedListener,
SetCurrentNetworkListener {

	private final DialogTaskManager taskManager;
	private final CyApplicationManager appManager;

	private MyWebServiceClient client;

	private boolean initialized = false;

	public MyWebServiceClientPanel(final DialogTaskManager taskManager, final CyApplicationManager appManager,
			final CyTableManager tblManager, final CyNetworkManager netManager) {

		this.taskManager = taskManager;
		this.appManager = appManager;
		
		initUI();
	}

	public void setClient(final MyWebServiceClient client) {
		this.client = client;

		this.addAncestorListener(new AncestorListener() {

			public void ancestorRemoved(AncestorEvent arg0) {
			}

			public void ancestorMoved(AncestorEvent arg0) {
			}

			public void ancestorAdded(AncestorEvent arg0) {
				if(!initialized)
					initPanel();
			}
		});
	}

	private void initPanel() {
		initialized = true;
		
		System.out.println("service location = "+ this.client.getServiceLocation());
	}

	private void initUI(){

		this.setBorder(BorderFactory.createTitledBorder("test test"));
		this.add(new JLabel("Test Test Test"));
	}

	public void handleEvent(final ColumnCreatedEvent e) {
		//System.out.println("\nGot ColumnCreatedEvent...");
	}

	public void handleEvent(final ColumnDeletedEvent e) {
		//System.out.println("\nGot ColumnDeletedEvent...");
	}
	
	public void handleEvent(final SetCurrentNetworkEvent e) {
		//System.out.println("\nGot SetCurrentNetworkEvent...");
	}
}
