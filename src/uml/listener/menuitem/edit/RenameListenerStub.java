package uml.listener.menuitem.edit;

import uml.graphic.component.panel.CanvasPanel;

public class RenameListenerStub extends EditListener {

    @Override
    protected void invokeCanvasAction(final CanvasPanel cPanel) {
        cPanel.getBounds();
    }
}
