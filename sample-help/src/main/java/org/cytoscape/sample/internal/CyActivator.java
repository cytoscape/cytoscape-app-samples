package org.cytoscape.sample.internal;

import java.net.URL;

import javax.help.HelpSet;

import org.cytoscape.application.swing.CyHelpBroker;
import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		CyHelpBroker cyHelpBroker = getService(context, CyHelpBroker.class);
		
		final String HELP_SET_NAME = "/help/jhelpset";
		final ClassLoader classLoader = getClass().getClassLoader();
		URL helpSetURL;
		try {
			helpSetURL = HelpSet.findHelpSet(classLoader, HELP_SET_NAME);
			final HelpSet newHelpSet = new HelpSet(classLoader, helpSetURL);
			cyHelpBroker.getHelpSet().add(newHelpSet);
		} catch (final Exception e) {
			System.err.println("sample-help: Could not find help set: \"" + HELP_SET_NAME + ".");
		}
	}

}
