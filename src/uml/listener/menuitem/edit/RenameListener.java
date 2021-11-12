package uml.listener.menuitem.edit;

import javax.swing.SwingUtilities;

import uml.graphic.component.dialog.RenameDialog;
import uml.graphic.component.panel.CanvasPanel;

public class RenameListener extends EditListener {

    @Override
    protected void invokeCanvasAction(final CanvasPanel cPanel) {
        cPanel.getSelectedDiagrams().forEach(d -> new RenameDialog(SwingUtilities.getWindowAncestor(cPanel), d));
    }
}
