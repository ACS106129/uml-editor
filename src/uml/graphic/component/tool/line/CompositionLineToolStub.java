package uml.graphic.component.tool.line;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.Line;
import uml.graphic.component.umlobject.line.CompositionLineStub;

public class CompositionLineToolStub extends LineTool {

    public CompositionLineToolStub() {
        super(ToolMode.CompositionLine, "/resources/image/tool/composition_line.png");
    }

    @Override
    protected Line generateLine(final Diagram d, final DiagramPortPosition pos) {
        return new CompositionLineStub();
    }
}
