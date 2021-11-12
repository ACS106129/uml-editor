package uml.graphic.component.tool.line;

import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.GeneralizationLine;
import uml.graphic.component.umlobject.line.Line;

public class GeneralizationLineTool extends LineTool {

    public GeneralizationLineTool(final String imagePathName) {
        super(ToolMode.GeneralizationLine, imagePathName);
    }

    @Override
    protected Line generateLine(final Diagram d, final DiagramPortPosition pos) {
        return new GeneralizationLine(d, pos);
    }
}