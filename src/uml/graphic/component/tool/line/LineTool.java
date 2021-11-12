package uml.graphic.component.tool.line;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Optional;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.tool.Tool;
import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.Line;

public abstract class LineTool extends Tool {

    private Optional<Line> renderLine = Optional.empty();
    private int currentLineZOrder = Integer.MAX_VALUE;

    public LineTool(final ToolMode mode, final String imagePathName) {
        super(mode, imagePathName);
    }

    @Override
    public void drawObject(final MouseEvent mouseEvent, final CanvasPanel cPanel) {
        final Point p = mouseEvent.getPoint();
        final List<Diagram> diagrams = cPanel.getDiagrams();
        switch (mouseEvent.getID()) {
        case MouseEvent.MOUSE_PRESSED:
            cPanel.getSelectedDiagrams().forEach(d -> d.setSelect(false));
            diagrams.stream().filter(d -> d.getPortPositionByContains(p).isPresent()).findFirst().ifPresent(d -> {
                renderLine = Optional.of(generateLine(d, d.getPortPositionByContains(p).orElseThrow()));
                currentLineZOrder = cPanel.getComponentZOrder(d);
                cPanel.add(renderLine.orElseThrow(), currentLineZOrder);
            });
            break;
        case MouseEvent.MOUSE_DRAGGED:
            renderLine.ifPresent(l -> {
                l.updateBufferedPoint(p);
                diagrams.stream().filter(d -> d.getBounds().contains(p)).findFirst().ifPresent(d -> {
                    if (!l.replaceDestDiagram(d))
                        return;
                    // change z-order if new dest's is smaller than current's
                    final int destZOrder = cPanel.getComponentZOrder(d);
                    if (destZOrder < currentLineZOrder) {
                        cPanel.setComponentZOrder(l, destZOrder);
                        currentLineZOrder = destZOrder;
                    }
                });
            });
            break;
        case MouseEvent.MOUSE_RELEASED:
            renderLine.ifPresent(l -> {
                // if did not hover on the port of any other diagrams, remove this render line
                if (!l.isHoverOnDestPort())
                    cPanel.remove(l);
                else
                    l.attachDiagram();
            });
            // clear up render line when released
            renderLine = Optional.empty();
            break;
        default:
            break;
        }
    }

    protected abstract Line generateLine(final Diagram d, final DiagramPortPosition pos);
}
