package org.cytoscape.sample.internal;


import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.property.MinimalVisualLexicon;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;


public class MyNodeViewTask extends AbstractTask {
	private View<CyNode> nodeView;
	private CyNetworkView netView;

	public MyNodeViewTask(View<CyNode> nodeView, CyNetworkView netView) {
		this.nodeView = nodeView;
		this.netView = netView;
	}

	public void run(TaskMonitor tm) throws Exception {
		
		// Double node size
		double newXSize =  nodeView.getVisualProperty(MinimalVisualLexicon.NODE_WIDTH)*2;
		double newYSize =  nodeView.getVisualProperty(MinimalVisualLexicon.NODE_HEIGHT)*2;
				
		nodeView.setVisualProperty(MinimalVisualLexicon.NODE_WIDTH, newXSize);
		nodeView.setVisualProperty(MinimalVisualLexicon.NODE_HEIGHT, newYSize);
		
		netView.updateView();
	} 
}
