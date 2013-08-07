package org.cytoscape.sample.internal;

import java.util.Map;
import org.cytoscape.io.webservice.WebServiceClient;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import java.util.Iterator;

public class UseWebServiceTask extends AbstractTask {

	private final WebServiceHelper webServiceHelper;
	
	public UseWebServiceTask(WebServiceHelper webServiceHelper){
		this.webServiceHelper = webServiceHelper;
	}
	
	@Override
	public void run(TaskMonitor taskMonitor) {
		
		Map<WebServiceClient, Map> webserviceMap = webServiceHelper.getWebserviceMap();
		
		Iterator<WebServiceClient> it = webserviceMap.keySet().iterator();
		
		while (it.hasNext()){
			WebServiceClient client = it.next();
			// Based on the serviceLocation, we can find if the client we are looking for is available
			System.out.println("Web Service Client: Display Name is "+client.getDisplayName());
			System.out.println("Web Service Client: Service Location is "+client.getServiceLocation());
		}
		
		// After we get the client we wanted, we can use it now
		//Object query = "xxx";
		//wsc.setQuery(query);
	
	}
}
