package org.cytoscape.sample.internal;

import java.util.HashSet;
import java.util.Properties;

import org.cytoscape.app.swing.AbstractCySwingApp;
import org.cytoscape.app.swing.CySwingAppAdapter;
import org.cytoscape.io.BasicCyFileFilter;
import org.cytoscape.io.DataCategory;
import org.cytoscape.io.read.InputStreamTaskFactory;

/**
 * 
 */
public class NetworkReaderApp extends AbstractCySwingApp {
	
	public NetworkReaderApp(CySwingAppAdapter swingAdapter){
		super(swingAdapter);

		// Define a filter
		HashSet<String> extensions = new HashSet<String>();
		extensions.add("tc");
		HashSet<String> contentTypes = new HashSet<String>();
		contentTypes.add("txt");
		String description = "Two column network file filter";
		DataCategory category = DataCategory.NETWORK;
		BasicCyFileFilter filter = new BasicCyFileFilter(extensions,contentTypes, description, category, swingAdapter.getStreamUtil());
		
		// Create an instance of the ReaderFactory
		TwoColumnNetworkReaderFactory factory = new TwoColumnNetworkReaderFactory(filter, swingAdapter.getCyNetworkFactory(), swingAdapter.getCyNetworkViewFactory());
		
		//register the ReaderFactory as an InputStreamTaskFactory.
		Properties props = new Properties();
		props.setProperty("readerDescription","Two column network reader");
		props.setProperty("readerId","twoColumnNetworkReader");
		swingAdapter.getCyServiceRegistrar().registerService(factory, InputStreamTaskFactory.class, props);
	}
}
