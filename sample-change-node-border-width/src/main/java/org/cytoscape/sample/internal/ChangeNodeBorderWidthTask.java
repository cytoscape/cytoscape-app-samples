package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNode;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.model.CyTableUtil;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.vizmap.VisualStyle;
import java.util.Iterator;
import java.util.List;

public class ChangeNodeBorderWidthTask extends AbstractTask {
	
	private CyNetworkView netView;
	private final VisualMappingManager vmmServiceRef;
	
	public ChangeNodeBorderWidthTask(final CyNetworkView netView, final VisualMappingManager vmmServiceRef){
		this.netView = netView;
		this.vmmServiceRef =vmmServiceRef;
	}
	
	public void run(TaskMonitor monitor) {
		
		//Get the selected nodes
		List<CyNode> nodes = CyTableUtil.getNodesInState(netView.getModel(),"selected",true);

		// Double the border width for all the selected nodes		
		Iterator<CyNode> it = nodes.iterator();		
		while (it.hasNext()){
			CyNode node = it.next();
			View<CyNode> nodeView = netView.getNodeView(node);

			double newLineWidth = nodeView.getVisualProperty(BasicVisualLexicon.NODE_BORDER_WIDTH)*2;
			//nodeView.setVisualProperty(BasicVisualLexicon.NODE_BORDER_WIDTH, lineWidth);
			nodeView.setLockedValue(BasicVisualLexicon.NODE_BORDER_WIDTH, newLineWidth);
		}
		
		// Apply the change to the view
		VisualStyle style = vmmServiceRef.getCurrentVisualStyle();
		style.apply(netView);
		netView.updateView();
	}
}
