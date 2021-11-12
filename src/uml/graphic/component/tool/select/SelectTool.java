package uml.graphic.component.tool.select;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.tool.Tool;
import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;

public class SelectTool extends Tool {

    private final Rectangle initRect = new Rectangle(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE));
    private final Point pressedStartPoint = new Point();
    private final Point draggedPoint = new Point();

    public SelectTool(final String imagePathName) {
        super(ToolMode.Select, imagePathName);
    }

    @Override
    public void drawObject(final MouseEvent mouseEvent, final CanvasPanel cPanel) {
        final Point p = mouseEvent.getPoint();
        final List<Diagram> diagrams = cPanel.getDiagrams();
        final List<Diagram> selectedDiagrams = cPanel.getSelectedDiagrams();
        switch (mouseEvent.getID()) {
        case MouseEvent.MOUSE_PRESSED:
            // if selected diagrams not in focus
            if (!selectedDiagrams.stream().anyMatch(d -> d.getContentBounds().orElseThrow().contains(p))) {
                // deselected all selected diagrams
                selectedDiagrams.forEach(d -> d.setSelect(false));
                final Diagram[] pressedDiagrams = diagrams.stream()
                        .filter(d -> d.getContentBounds().orElseThrow().contains(p)).toArray(Diagram[]::new);
                // no diagrams in pressed point -> trigger multiple selecting
                if (pressedDiagrams.length == 0)
                    cPanel.selectedRect.setBounds(p.x, p.y, 0, 0);
                // single selecting and draggable
                else {
                    pressedDiagrams[0].setSelect(true);
                    cPanel.setComponentZOrder(pressedDiagrams[0], 1);
                    pressedDiagrams[0].getAttachedLines().forEach(l -> cPanel.setComponentZOrder(l, 1));
                    cPanel.selectedRect.setBounds(initRect);
                }
            }
            pressedStartPoint.setLocation(p);
            draggedPoint.setLocation(p);
            break;
        case MouseEvent.MOUSE_DRAGGED:
            // multiple selecting
            if (!cPanel.selectedRect.equals(initRect)) {
                cPanel.selectedRect.setBounds(pressedStartPoint.x, pressedStartPoint.y, 0, 0);
                cPanel.selectedRect.add(p);
                diagrams.forEach(d -> d.setSelect(cPanel.selectedRect.contains(d.getContentBounds().orElseThrow())));
                break;
            }
            // moving selected diagrams
            selectedDiagrams.forEach(d -> {
                final Point currentPoint = d.getLocation();
                d.setLocation(currentPoint.x + p.x - draggedPoint.x, currentPoint.y + p.y - draggedPoint.y);
            });
            draggedPoint.setLocation(p);
            break;
        case MouseEvent.MOUSE_RELEASED:
            // multiple selecting
            if (!cPanel.selectedRect.equals(initRect)) {
                Collections.reverse(selectedDiagrams);
                selectedDiagrams.forEach(d -> {
                    cPanel.setComponentZOrder(d, 1);
                    d.getAttachedLines().forEach(l -> cPanel.setComponentZOrder(l, 1));
                });
            }
            // clear selected rect render
            cPanel.selectedRect.setBounds(initRect);
            break;
        default:
            break;
        }
    }
}