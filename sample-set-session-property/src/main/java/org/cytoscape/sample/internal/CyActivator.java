package org.cytoscape.sample.internal;


import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.cytoscape.app.CyAppAdapter;
import org.cytoscape.property.CyProperty;
import org.cytoscape.property.SimpleCyProperty;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.session.CySession;
import org.cytoscape.session.CySessionManager;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}

	//1. Adding a property which saves the node border width selected by the user.
	public static String NodeBorderWidthInPaths = "NODE_BORDER_WIDTH_IN_PATHS";
	public static Double NodeBorderWidthInPathsValue = 20.0;
	public static Properties nodeBorderWidthProps = new Properties();

	public void start(BundleContext bc) {


		CyAppAdapter adapter = getService(bc,CyAppAdapter.class);

		//2. Find if the CyProperty already exists, if not create one with default value.
		CyProperty<Properties> nodeBorderWidthProperty = null;
		CySessionManager mySessionManager;
		mySessionManager = adapter.getCySessionManager();
		CySession session;
		session = mySessionManager.getCurrentSession();
		if(session.equals(null))
			System.out.println("session null");
			
		//3. Get all properties and loop through to find your own.
		Set<CyProperty<?>> props = new HashSet<CyProperty<?>>();
		props = session.getProperties();
		if(props.equals(null))
			System.out.println("props null");
		boolean flag = false;
		
		for (CyProperty<?> prop : props) {
		    if (prop.getName() != null){
		    	if (prop.getName().equals(NodeBorderWidthInPaths)) {
		        nodeBorderWidthProperty = (CyProperty<Properties>) prop;
		        flag = true;
		        break;
		    	}
		    }
		}
		
		//4. If the property does not exists, create nodeBorderWidthProperty
		if (!flag)
		{
			nodeBorderWidthProps.setProperty(NodeBorderWidthInPaths, NodeBorderWidthInPathsValue.toString());
			nodeBorderWidthProperty = new 
					SimpleCyProperty(NodeBorderWidthInPaths, 
							nodeBorderWidthProps, Float.TYPE, CyProperty.SavePolicy.SESSION_FILE_AND_CONFIG_DIR );
		}
		//5. If not null, property exists, get value from it and set NodeBorderWidthInPathsValue
		else
		{
			nodeBorderWidthProps = nodeBorderWidthProperty.getProperties();
			NodeBorderWidthInPathsValue = Double.valueOf((String)nodeBorderWidthProps.get(NodeBorderWidthInPaths));
		}

		
		registerService(bc,nodeBorderWidthProperty,CyProperty.class, new Properties());
	}
}

