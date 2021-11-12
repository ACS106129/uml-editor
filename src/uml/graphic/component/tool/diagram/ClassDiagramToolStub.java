package uml.graphic.component.tool.diagram;

import java.awt.Point;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.content.ClassDiagramContentStub;

public class ClassDiagramToolStub extends DiagramTool {

    public ClassDiagramToolStub() {
        super(ToolMode.ClassDiagram, "/resources/image/tool/class_diagram.png");
    }

    @Override
    protected Diagram generateDiagram(final int portSize, final Point pos) {
        return new Diagram(10, new Point(), new ClassDiagramContentStub());
    }
}
