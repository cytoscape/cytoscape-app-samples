package org.cytoscape.sample.internal;

import java.util.Set;

import org.cytoscape.io.webservice.NetworkImportWebServiceClient;
import org.cytoscape.io.webservice.client.AbstractWebServiceClient;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.work.TaskIterator;

public class Sample14 extends AbstractWebServiceClient implements
		NetworkImportWebServiceClient {

	public Sample14(String uri, String displayName, String description) {
		super(uri, displayName, description);
	}

	@Override
	public TaskIterator getTaskIterator() {
		ImportNetworkTask importTask = new ImportNetworkTask();
		return new TaskIterator(importTask);
	}

	@Override
	public Set<CyNetwork> getNetworks() {
		return null;
	}

}
