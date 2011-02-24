package org.cytoscape.sample.internal;


import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.property.TwoDVisualLexicon;
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
		double newXSize =  nodeView.getVisualProperty(TwoDVisualLexicon.NODE_X_SIZE)*2;
		double newYSize =  nodeView.getVisualProperty(TwoDVisualLexicon.NODE_Y_SIZE)*2;
				
		nodeView.setVisualProperty(TwoDVisualLexicon.NODE_X_SIZE, newXSize);
		nodeView.setVisualProperty(TwoDVisualLexicon.NODE_Y_SIZE, newYSize);
		
		netView.updateView();
	} 
}
