package uml.graphic.component.umlobject.diagram;

import java.awt.Point;

import uml.graphic.component.umlobject.diagram.content.ClassDiagramContentStub;

public class DiagramStub extends Diagram {

    public DiagramStub() {
        super(10, new Point(), new ClassDiagramContentStub());
    }
}
