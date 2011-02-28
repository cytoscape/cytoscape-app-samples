package org.cytoscape.sample.internal;

import org.cytoscape.session.events.SessionAboutToBeSavedEvent;
import org.cytoscape.session.events.SessionLoadedEvent;
import org.cytoscape.session.events.SessionAboutToBeSavedListener;
import org.cytoscape.session.events.SessionLoadedListener;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class Sample21 implements SessionAboutToBeSavedListener, SessionLoadedListener {


	// Save plugin state in a file
	public void handleEvent(SessionAboutToBeSavedEvent e){
	
		String tmpDir = System.getProperty("java.io.tmpdir");
		File propFile = new File(tmpDir, "sample21.props");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(propFile));
			writer.write("Line 1");			
			writer.newLine();
			writer.write("Line 2");

			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		ArrayList<File> files = new ArrayList<File>();
		files.add(propFile);
		try {
			e.addPluginFiles("sample21", files);			
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
	

	// restore plugin state from a file
	public void handleEvent(SessionLoadedEvent e){

		if (e.getLoadedSession().getPluginFileListMap() == null || e.getLoadedSession().getPluginFileListMap().size() ==0){
			return;
		}
		
		List<File> files = e.getLoadedSession().getPluginFileListMap().get("sample21");

		if (files == null || files.size() ==0){
			return;
		}

		try {			
			File propFile = files.get(0);
			
			BufferedReader in = new BufferedReader(new FileReader(propFile));

			String firstLine = in.readLine();			
			String secondLine = in.readLine();
			
			System.out.println("\tsample21.props:  " + firstLine);
			System.out.println("\tsample21.props:  " + secondLine);

			in.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
}
