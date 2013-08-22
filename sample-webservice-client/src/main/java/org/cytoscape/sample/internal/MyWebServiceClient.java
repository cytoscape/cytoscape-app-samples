/*
 Copyright (c) 2006, 2007, 2011, The Cytoscape Consortium (www.cytoscape.org)

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

import javax.naming.ConfigurationException;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.io.webservice.TableImportWebServiceClient;
//import org.cytoscape.io.webservice.biomart.rest.BiomartRestClient;
//import org.cytoscape.io.webservice.biomart.task.ImportTableTask;
//import org.cytoscape.io.webservice.biomart.ui.BiomartAttrMappingPanel;
import org.cytoscape.io.webservice.swing.AbstractWebServiceGUIClient;
import org.cytoscape.model.CyTableFactory;
import org.cytoscape.model.CyTableManager;
import org.cytoscape.task.edit.MapTableToNetworkTablesTaskFactory;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.work.TaskMonitor;
import org.osgi.framework.ServiceException;
import org.cytoscape.work.AbstractTask;


/**
 * My Web Service Client.
 * 
 */
public class MyWebServiceClient extends AbstractWebServiceGUIClient implements TableImportWebServiceClient {
	
	private final CyTableFactory tableFactory;
	private final CySwingApplication app;
	private final CyTableManager tableManager;
	private final MapTableToNetworkTablesTaskFactory mapNetworkAttrTF;

	private final static String baseURL = "http://website/webservice";

	/**
	 * Creates a new web service Client object.
	 * 
	 * @throws ServiceException
	 * @throws ConfigurationException
	 */
	public MyWebServiceClient(final String displayName, final String description,
	                     final CyTableFactory tableFactory,
	                     final CySwingApplication app, final CyTableManager tableManager,
						 final MyWebServiceClientPanel gui,
						 final MapTableToNetworkTablesTaskFactory mapNetworkAttrTF)
	{
		super(baseURL, displayName, description);

		this.tableFactory         = tableFactory;
		this.app                  = app;
		this.tableManager         = tableManager;
		this.mapNetworkAttrTF     = mapNetworkAttrTF;
		this.gui = gui;
	}


	public TaskIterator createTaskIterator(Object query) {
		if (gui == null)
			throw new IllegalStateException(
					"Could not build query because Query Builder GUI is null.");

		System.out.println("\nbaseURL = "+ baseURL);
		System.out.println("query = "+ query);
		 
		// do something here
		ImportTask importTask = new ImportTask();

		return new TaskIterator(importTask);
	}
	
	//
	class ImportTask extends AbstractTask {
		 public void run(TaskMonitor taskMonitor) throws Exception {
			 System.out.println("\nDo something here...\n\n");
		 }
	}
}
