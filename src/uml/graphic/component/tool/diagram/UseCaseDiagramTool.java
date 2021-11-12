package uml.graphic.component.tool.diagram;

import java.awt.Point;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.content.UseCaseDiagramContent;

public class UseCaseDiagramTool extends DiagramTool {

    public UseCaseDiagramTool(final String imagePathName) {
        super(ToolMode.UseCaseDiagram, imagePathName);
    }

    @Override
    protected Diagram generateDiagram(final int portSize, final Point pos) {
        return new Diagram(portSize, pos, new UseCaseDiagramContent());
    }
}
