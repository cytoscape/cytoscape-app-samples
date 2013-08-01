package org.cytoscape.sample.internal;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTableFactory;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.io.read.CyTableReader;
import org.cytoscape.model.CyTable;

public class MyTableReader extends AbstractTask  implements CyTableReader {

	private CyTable[] cyTables;
	private final InputStream stream;
	private CyTableFactory tableFactory;
	private static int nextTableNumber = 1;
	
	public MyTableReader(InputStream stream, CyTableFactory tableFactory) {
		this.stream = stream;
		this.tableFactory = tableFactory;
	}


	public void run(TaskMonitor taskMonitor) throws Exception {

		taskMonitor.setProgress(0.0);

		// create a new table
		final CyTable table = tableFactory.createTable(
				"Table " + Integer.toString(nextTableNumber++), CyNetwork.NAME,
				String.class, true, true);
		cyTables = new CyTable[] { table };
		taskMonitor.setProgress(0.1);

		try {
			final InputStreamReader reader1 = new InputStreamReader(this.stream);
			final BufferedReader reader = new BufferedReader(reader1);

			// the first line is the header
			String attributeName;
			final String firstLine = reader.readLine();
			String[] items = firstLine.split("\t");
			String keyAtt = items[0];
			attributeName = items[1];

			// read the attribute data now, assume it is tab-delimited
			while (true) {
				final String line = reader.readLine();
				if (line == null){
					break;
				}
				if (line.trim().equals("")){
					continue;
				}
				
				items = line.split("\t");
				String key = items[0];
				String value = items[1];

				if (table.getColumn(attributeName) == null) {
						table.createColumn(attributeName, Integer.class, false);
				}

				CyRow row = table.getRow(key);
				row.set(attributeName, new Integer(value));
			}
			
			taskMonitor.setProgress(0.5);
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
		taskMonitor.setProgress(1.0);	
	}

	public CyTable[] getTables(){
		return cyTables;
	}
}
