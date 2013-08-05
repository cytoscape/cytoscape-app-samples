package org.cytoscape.sample.internal;

import java.util.Map;
import java.util.Properties;
import org.cytoscape.property.CyProperty;



public class MyServiceListener {

	public MyServiceListener(){
		
	}
	
	public void addPropertyService(CyProperty<Properties> cmd, Map p ){
		
		System.out.println("\tFound CyProperty service = "+p.get("cyPropertyName")+ "\n");
		
	}

	public void  removePropertyService(CyProperty<Properties> cmd, Map p ){

	}	
}
