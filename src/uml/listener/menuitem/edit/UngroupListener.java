package uml.listener.menuitem.edit;

import java.util.Collections;
import java.util.List;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.GroupDiagram;

public class UngroupListener extends EditListener {

    @Override
    protected void invokeCanvasAction(final CanvasPanel cPanel) {
        final List<Diagram> selectedDiagrams = cPanel.getSelectedDiagrams();
        if (selectedDiagrams.size() != 1 || !(selectedDiagrams.get(0) instanceof GroupDiagram))
            return;
        final GroupDiagram group = (GroupDiagram) selectedDiagrams.get(0);
        final List<Diagram> diagrams = group.ungroup();
        Collections.reverse(diagrams);
        // append diagrams back to canvas panel
        diagrams.forEach(d -> {
            cPanel.add(d, 1);
            // adjust z order
            d.getAttachedLines().forEach(l -> cPanel.setComponentZOrder(l, 1));
        });
        cPanel.remove(group);
    }
}
