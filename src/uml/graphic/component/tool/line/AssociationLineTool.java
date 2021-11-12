package uml.graphic.component.tool.line;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.AssociationLine;
import uml.graphic.component.umlobject.line.Line;

public class AssociationLineTool extends LineTool {

    public AssociationLineTool(final String imagePathName) {
        super(ToolMode.AssociationLine, imagePathName);
    }

    @Override
    protected Line generateLine(final Diagram d, final DiagramPortPosition pos) {
        return new AssociationLine(d, pos);
    }
}