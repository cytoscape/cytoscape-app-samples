package org.cytoscape.sample.internal;

import java.io.InputStream;
import org.cytoscape.io.CyFileFilter;
import org.cytoscape.io.read.AbstractInputStreamTaskFactory;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.work.TaskIterator;

public class TwoColumnNetworkReaderFactory extends AbstractInputStreamTaskFactory {

	
	private CyNetworkFactory networkFactory;
	private CyNetworkViewFactory viewFactory;
	
	public TwoColumnNetworkReaderFactory(CyFileFilter filter, CyNetworkFactory networkFactory,CyNetworkViewFactory viewFactory) {
		super(filter);
		this.networkFactory = networkFactory;
		this.viewFactory = viewFactory;
	}
	
	public TaskIterator createTaskIterator(InputStream stream, String inputName) {
		return new TaskIterator(new TwoColumnNetworkReader(stream, this.networkFactory, this.viewFactory));
	}
}

