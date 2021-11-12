package uml.listener.menuitem.edit;

import java.util.List;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.GroupDiagram;

public class GroupListener extends EditListener {

    @Override
    protected void invokeCanvasAction(final CanvasPanel cPanel) {
        final List<Diagram> selectedDiagrams = cPanel.getSelectedDiagrams();
        if (selectedDiagrams.size() < 2)
            return;
        selectedDiagrams.forEach(cPanel::remove);
        final GroupDiagram group = new GroupDiagram(selectedDiagrams);
        group.setSelect(true);
        cPanel.add(group, 1);
    }
}
