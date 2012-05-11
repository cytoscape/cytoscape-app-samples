package org.cytoscape.sample.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import org.cytoscape.io.read.CyNetworkReader;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyRow;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class TCReader extends AbstractTask implements CyNetworkReader  {
//	reads the file and creates a CyNetwork.
	private static final int BUFFER_SIZE = 16384;
	
	private final InputStream stream;
	private final CyNetworkFactory networkFactory;
	private final CyNetworkViewFactory viewFactory;
	private CyNetwork network;
	
	public TCReader(InputStream stream, CyNetworkFactory networkFactory, CyNetworkViewFactory viewFactory) {
		this.stream = stream;
		this.networkFactory = networkFactory;
		this.viewFactory = viewFactory;
	}


	public void run(TaskMonitor taskMonitor) throws Exception {
		String text = readString(stream);
		
		
		network = networkFactory.createNetwork();
		
		
		CyNode node = network.addNode();
		CyRow attributes = network.getRow(node);
		attributes.set("name", "NAMENAME");
		
		
		
		
		
	}
	
	public CyNetwork[] getNetworks() {
		return new CyNetwork[] { network };
	}

	public CyNetworkView buildCyNetworkView(CyNetwork network) {
		return viewFactory.createNetworkView(network);
	}
	
	private static String readString(InputStream source) throws IOException {
		StringWriter writer = new StringWriter();
		BufferedReader reader = new BufferedReader(new InputStreamReader(source));
		try {
			char[] buffer = new char[BUFFER_SIZE];
			int charactersRead = reader.read(buffer, 0, buffer.length);
			while (charactersRead != -1) {
				writer.write(buffer, 0, charactersRead);
				charactersRead = reader.read(buffer, 0, buffer.length);
			}
		} finally {
			reader.close();
		}
		return writer.toString();
	}
}
