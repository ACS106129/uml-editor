package uml.graphic.component.tool.line;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.CompositionLine;
import uml.graphic.component.umlobject.line.Line;

public class CompositionLineTool extends LineTool {

    public CompositionLineTool(final String imagePathName) {
        super(ToolMode.CompositionLine, imagePathName);
    }

    @Override
    protected Line generateLine(final Diagram d, final DiagramPortPosition pos) {
        return new CompositionLine(d, pos);
    }
}