package uml.graphic.component.tool.line;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.Line;
import uml.graphic.component.umlobject.line.GeneralizationLineStub;

public class GeneralizationLineToolStub extends LineTool {

    public GeneralizationLineToolStub() {
        super(ToolMode.GeneralizationLine, "/resources/image/tool/generalization_line.png");
    }

    @Override
    protected Line generateLine(final Diagram d, final DiagramPortPosition pos) {
        return new GeneralizationLineStub();
    }
}
