package uml.graphic.component.tool.diagram;

import java.awt.Point;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.content.ClassDiagramContent;

public class ClassDiagramTool extends DiagramTool {

    public ClassDiagramTool(final String imagePathName) {
        super(ToolMode.ClassDiagram, imagePathName);
    }

    @Override
    protected Diagram generateDiagram(final int portSize, final Point pos) {
        return new Diagram(portSize, pos, new ClassDiagramContent());
    }
}
