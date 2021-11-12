package uml.graphic.component.umlobject.line;

import java.awt.Graphics;
import java.awt.Point;

import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.content.ClassDiagramContentStub;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;

public class AssociationLineStub extends Line {

    public AssociationLineStub() {
        super(new Diagram(0, new Point(), new ClassDiagramContentStub()), DiagramPortPosition.Left);
    }

    @Override
    protected void render(final Graphics g, final Point startPoint, final Point endPoint) {
    }
}
