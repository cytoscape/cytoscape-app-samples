package org.cytoscape.sample.sample24.internal;

import java.awt.event.ActionEvent;
import java.net.URL;
import org.cytoscape.application.swing.CyHelpBroker;
import javax.help.HelpSet;


/**
 * Creates a new menu item under Apps menu section.
 *
 */
public class MenuAction {

	private final CyHelpBroker cyHelpBroker;
	public MenuAction(CyHelpBroker cyHelpBroker) {
		this.cyHelpBroker = cyHelpBroker;
		
		addHelp();
	}

	/**
	 *  Hook plugin help into the Cytoscape main help system:
	 */
	private void addHelp() {
		final String HELP_SET_NAME = "/help/jhelpset";
		final ClassLoader classLoader = MenuAction.class.getClassLoader();
		URL helpSetURL;
		try {
			helpSetURL = HelpSet.findHelpSet(classLoader, HELP_SET_NAME);
			final HelpSet newHelpSet = new HelpSet(classLoader, helpSetURL);
			cyHelpBroker.getHelpSet().add(newHelpSet);
		} catch (final Exception e) {
			System.err.println("Sample24: Could not find help set: \"" + HELP_SET_NAME + "!");
		}
	}
}
