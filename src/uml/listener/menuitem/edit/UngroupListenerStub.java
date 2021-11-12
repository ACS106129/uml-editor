package uml.listener.menuitem.edit;

import uml.graphic.component.panel.CanvasPanel;

public class UngroupListenerStub extends EditListener {

    @Override
    protected void invokeCanvasAction(final CanvasPanel cPanel) {
        cPanel.getBounds();
    }
}
