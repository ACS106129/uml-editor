package uml.listener.menuitem.edit;

import java.awt.Component;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.GroupDiagram;

public class DeleteListener extends EditListener {

    @Override
    protected void invokeCanvasAction(final CanvasPanel cPanel) {
        cPanel.getSelectedDiagrams().forEach(d -> {
            recursiveDetachAllLines(d);
            cPanel.remove(d);
        });
    }

    private void recursiveDetachAllLines(final Diagram d) {
        d.detachAllLines();
        for (final Component comp : d.getComponents()) {
            if (comp instanceof GroupDiagram)
                recursiveDetachAllLines((GroupDiagram) comp);
            else if (comp instanceof Diagram)
                ((Diagram) comp).detachAllLines();
        }
    }
}
