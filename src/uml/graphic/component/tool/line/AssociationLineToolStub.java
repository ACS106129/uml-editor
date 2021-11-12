package uml.graphic.component.tool.line;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.Line;
import uml.graphic.component.umlobject.line.AssociationLineStub;

public class AssociationLineToolStub extends LineTool {

    public AssociationLineToolStub() {
        super(ToolMode.AssociationLine, "/resources/image/tool/association_line.png");
    }

    @Override
    protected Line generateLine(final Diagram d, final DiagramPortPosition pos) {
        return new AssociationLineStub();
    }
}
