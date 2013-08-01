package org.cytoscape.sample.internal;

import java.io.InputStream;
import org.cytoscape.io.CyFileFilter;
import org.cytoscape.io.read.AbstractInputStreamTaskFactory;
import org.cytoscape.model.CyTableFactory;
import org.cytoscape.work.TaskIterator;

public class MyTableReaderFactory extends AbstractInputStreamTaskFactory {

	private CyTableFactory tableFactory;
	
	public MyTableReaderFactory(CyFileFilter filter, CyTableFactory tableFactory) {
		super(filter);
		this.tableFactory = tableFactory;
	}
	
	public TaskIterator createTaskIterator(InputStream stream, String inputName) {
		return new TaskIterator(new MyTableReader(stream, this.tableFactory));
	}
}

