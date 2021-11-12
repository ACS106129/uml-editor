package uml.graphic.component.umlobject.diagram.port;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import uml.graphic.component.umlobject.UMLObject;
import uml.graphic.component.umlobject.line.Line;

public class DiagramPort extends UMLObject {

    public final List<Line> attachedLines = new ArrayList<>();
    public final int size;

    public DiagramPort(final int size) {
        this.size = size;
        setSize(new Dimension(size, size));
        setBackground(Color.BLACK);
        setVisible(false);
    }

    @Override
    public String toString() {
        return "[port - " + getBounds().toString() + "]";
    }
}
