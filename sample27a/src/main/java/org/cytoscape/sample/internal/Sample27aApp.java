package org.cytoscape.sample.internal;

import java.util.HashSet;
import java.util.Properties;
import org.cytoscape.app.swing.AbstractCySwingApp;
import org.cytoscape.app.swing.CySwingAppAdapter;
import org.cytoscape.io.BasicCyFileFilter;
import org.cytoscape.io.DataCategory;
import org.cytoscape.io.read.InputStreamTaskFactory;
import org.cytoscape.io.util.StreamUtil;

/**
 * 
 */
public class Sample27aApp extends AbstractCySwingApp {
	
	public Sample27aApp(CySwingAppAdapter swingAdapter){
		super(swingAdapter);

		// Define a filter
		HashSet<String> extensions = new HashSet<String>();
		extensions.add("tc");
		HashSet<String> contentTypes = new HashSet<String>();
		contentTypes.add("txt");
		String description = "My test filter";
		DataCategory category = DataCategory.NETWORK;
		BasicCyFileFilter filter = new BasicCyFileFilter(extensions,contentTypes, description, category, swingAdapter.getStreamUtil());
		
		// Create an instance of the ReaderFactory
		TCReaderFactory factory = new TCReaderFactory(filter, swingAdapter.getCyNetworkFactory(), swingAdapter.getCyNetworkViewFactory());
		
		//register the ReaderFactory as an InputStreamTaskFactory.
		Properties props = new Properties();
		props.setProperty("readerDescription","TC file reader");
		props.setProperty("readerId","tcNetworkReader");
		swingAdapter.getCyServiceRegistrar().registerService(factory, InputStreamTaskFactory.class, props);
	}
}
