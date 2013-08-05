package org.cytoscape.sample.internal;

import java.io.InputStream;
import org.cytoscape.io.CyFileFilter;
import org.cytoscape.io.read.AbstractInputStreamTaskFactory;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.work.TaskIterator;

public class TCReaderFactory extends AbstractInputStreamTaskFactory {

	
	private CyNetworkFactory networkFactory;
	private CyNetworkViewFactory viewFactory;
	
	public TCReaderFactory(CyFileFilter filter, CyNetworkFactory networkFactory,CyNetworkViewFactory viewFactory) {
		super(filter);
		this.networkFactory = networkFactory;
		this.viewFactory = viewFactory;
	}
	
	public TaskIterator createTaskIterator(InputStream stream, String inputName) {
		return new TaskIterator(new TCReader(stream, this.networkFactory, this.viewFactory));
	}
}

