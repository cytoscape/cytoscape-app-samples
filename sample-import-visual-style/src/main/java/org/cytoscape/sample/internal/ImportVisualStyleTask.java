package org.cytoscape.sample.internal;

import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
import org.cytoscape.task.read.LoadVizmapFileTaskFactory;
import org.cytoscape.task.visualize.ApplyVisualStyleTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskIterator;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ImportVisualStyleTask extends AbstractTask {

	@Tunable(description = "Vizmap file", params = "fileCategory=vizmap;input=true")
	public File f;

	private final LoadVizmapFileTaskFactory loadVizmapFileTaskFactory;
	private CyNetworkView view;
	private final ApplyVisualStyleTaskFactory applyVisualStyleTaskFactory;

	public ImportVisualStyleTask(LoadVizmapFileTaskFactory loadVizmapFileTaskFactory, CyNetworkView view,
			ApplyVisualStyleTaskFactory applyVisualStyleTaskFactory) {
		this.loadVizmapFileTaskFactory = loadVizmapFileTaskFactory;
		this.view = view;
		this.applyVisualStyleTaskFactory = applyVisualStyleTaskFactory;
	}

	@Override
	public void run(TaskMonitor taskMonitor) {

		taskMonitor.setStatusMessage("Loading visual styles from file ...");

		Set<VisualStyle> vsSet = loadVizmapFileTaskFactory.loadStyles(f);

		if (view == null || vsSet.size() == 0)
			return;

		// Apply one loaded visual style to teh given view
		final Set<CyNetworkView> views = new HashSet<CyNetworkView>();
		views.add(view);
		TaskIterator ti = this.applyVisualStyleTaskFactory.createTaskIterator(views);

		this.insertTasksAfterCurrentTask(ti);
	}
}
