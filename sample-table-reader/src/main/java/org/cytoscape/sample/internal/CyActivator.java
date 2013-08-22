package org.cytoscape.sample.internal;

import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.HashSet;
import java.util.Properties;
import org.cytoscape.io.BasicCyFileFilter;
import org.cytoscape.io.DataCategory;
import org.cytoscape.io.read.InputStreamTaskFactory;
import org.cytoscape.io.util.StreamUtil;
import org.cytoscape.model.CyTableFactory;

public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {
		StreamUtil streamUtil = getService(bc,StreamUtil.class);		
		CyTableFactory cyDataTableFactoryServiceRef = getService(bc,CyTableFactory.class);
	
		// Define a filter
		HashSet<String> extensions = new HashSet<String>();
		extensions.add("myext");
		HashSet<String> contentTypes = new HashSet<String>();
		contentTypes.add("txt");
		String description = "My table filter";
		DataCategory category = DataCategory.TABLE;
		BasicCyFileFilter filter = new BasicCyFileFilter(extensions,contentTypes, description, category, streamUtil);
		
		// Create an instance of the ReaderFactory
		MyTableReaderFactory myTableReader = new MyTableReaderFactory(filter, cyDataTableFactoryServiceRef);
					
		//register the ReaderFactory as an InputStreamTaskFactory.
		Properties props = new Properties();
		props.setProperty("readerDescription","My table reader");
		props.setProperty("readerId","MyTableReader");

		registerService(bc,myTableReader, InputStreamTaskFactory.class, props);
	}
}

