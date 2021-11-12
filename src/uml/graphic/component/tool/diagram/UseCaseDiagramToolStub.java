package uml.graphic.component.tool.diagram;

import java.awt.Point;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.content.UseCaseDiagramContentStub;

public class UseCaseDiagramToolStub extends DiagramTool {

    public UseCaseDiagramToolStub() {
        super(ToolMode.UseCaseDiagram, "/resources/image/tool/use_case_diagram.png");
    }

    @Override
    protected Diagram generateDiagram(final int portSize, final Point pos) {
        return new Diagram(10, new Point(), new UseCaseDiagramContentStub());
    }
}
