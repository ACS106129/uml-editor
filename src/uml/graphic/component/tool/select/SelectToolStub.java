package uml.graphic.component.tool.select;

import java.awt.event.MouseEvent;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.tool.Tool;
import uml.graphic.component.tool.mode.ToolMode;

public class SelectToolStub extends Tool {

    public SelectToolStub() {
        super(ToolMode.Select, "/resources/image/tool/select.png");
    }

    @Override
    public void drawObject(final MouseEvent mouseEvent, final CanvasPanel cPanel) {
        mouseEvent.getSource();
        cPanel.getBounds();
    }
}
