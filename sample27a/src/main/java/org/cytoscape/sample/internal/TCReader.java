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
import java.util.HashMap;


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
		
		String[] lines = text.split("\n");

		if (lines.length == 0){
			return;
		}

		network = networkFactory.createNetwork();

		HashMap<String, CyNode> nodeNameMap = new HashMap<String, CyNode>();
		
		for (int i=0; i< lines.length; i++){
			String line = lines[i];
			String[] items = line.split("\t");
			String name1 = items[0].trim();
			String name2 = items[1].trim();

			CyNode node1 = null;
			CyNode node2 = null;

			// for Node1
			if (nodeNameMap.containsKey(name1)){
				// Node already existed, get a reference to it
				node1 = nodeNameMap.get(name1);
			}
			else {
				// Node does not exist, create new one
				node1 = network.addNode();				
				CyRow attributes = network.getRow(node1);
				attributes.set("name", name1);	
				nodeNameMap.put(name1, node1);	
			}

			// for Node2
			if (nodeNameMap.containsKey(name2)){
				// Node already existed, get a reference to it
				node2 = nodeNameMap.get(name2);
			}
			else {
				// Node does not exist, create new one
				node2 = network.addNode();				
				CyRow attributes = network.getRow(node2);
				attributes.set("name", name2);
				nodeNameMap.put(name2, node2);
			}
			
			// Create an edge between node1 and node2
			network.addEdge(node1, node2, true);
		}
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
