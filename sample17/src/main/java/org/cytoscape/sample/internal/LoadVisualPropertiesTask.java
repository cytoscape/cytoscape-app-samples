package org.cytoscape.sample.internal;


import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
import org.cytoscape.task.creation.LoadVisualStyles;
import java.io.File;
import java.util.Set;

public class LoadVisualPropertiesTask extends AbstractTask {

	@Tunable(description = "Vizmap file", params = "fileCategory=vizmap;input=true")
	public File f;

	private final LoadVisualStyles loadVizmapFileTaskFactory;

	public LoadVisualPropertiesTask(LoadVisualStyles loadVizmapFileTaskFactory){
		this.loadVizmapFileTaskFactory = loadVizmapFileTaskFactory;
	}


	@Override
	public void run(TaskMonitor taskMonitor) {

		taskMonitor.setStatusMessage("Loading visual styles from file ...");

		Set<VisualStyle> vsSet = loadVizmapFileTaskFactory.loadStyles(f);

		System.out.println("Number of VisualStyles loaded = "+vsSet.size());

	}
}
