package uml.graphic.component.tool.diagram;

import java.awt.Point;
import java.awt.event.MouseEvent;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.tool.Tool;
import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;

public abstract class DiagramTool extends Tool {

    public DiagramTool(final ToolMode mode, final String imagePathName) {
        super(mode, imagePathName);
    }

    @Override
    public void drawObject(final MouseEvent mouseEvent, final CanvasPanel cPanel) {
        if (mouseEvent.getButton() != MouseEvent.BUTTON1)
            return;
        switch (mouseEvent.getID()) {
        case MouseEvent.MOUSE_PRESSED:
            cPanel.add(generateDiagram(12, mouseEvent.getPoint()));
            break;
        default:
            break;
        }
    }

    protected abstract Diagram generateDiagram(final int portSize, final Point pos);
}
