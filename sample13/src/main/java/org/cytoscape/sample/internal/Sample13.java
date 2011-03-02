package org.cytoscape.sample.internal;

import java.util.Map;

import org.cytoscape.io.webservice.WebServiceClient;

public class Sample13 {
	
	private WebServiceClient client;
	
	private final String serviceURI;

	public Sample13(final String serviceURI) {
		this.serviceURI = serviceURI;
	}
	
	public void addClient(WebServiceClient client, Map props) {
		final String clientURI = client.getServiceLocation().toASCIIString();
		if(clientURI.equals(serviceURI))
			this.client = client;
	}
	
	public void removeClient(WebServiceClient client, Map props) {
		// Do not need to handle remove events.
	}
	
	public void doSomethingWithClient() {
		client.getTaskIterator();
	}

}
