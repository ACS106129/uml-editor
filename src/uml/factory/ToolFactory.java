package uml.factory;

import uml.graphic.component.tool.Tool;
import uml.graphic.component.tool.diagram.ClassDiagramTool;
import uml.graphic.component.tool.diagram.UseCaseDiagramTool;
import uml.graphic.component.tool.line.AssociationLineTool;
import uml.graphic.component.tool.line.CompositionLineTool;
import uml.graphic.component.tool.line.GeneralizationLineTool;
import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.tool.select.SelectTool;

public class ToolFactory {

    private ToolFactory() {
    }

    public static Tool generate(final String imagePathName, final ToolMode mode) {
        switch (mode) {
        case Select:
            return new SelectTool(imagePathName);
        case AssociationLine:
            return new AssociationLineTool(imagePathName);
        case GeneralizationLine:
            return new GeneralizationLineTool(imagePathName);
        case CompositionLine:
            return new CompositionLineTool(imagePathName);
        case ClassDiagram:
            return new ClassDiagramTool(imagePathName);
        case UseCaseDiagram:
            return new UseCaseDiagramTool(imagePathName);
        default:
            throw new IllegalArgumentException(String.format("Wrong icon mode: %d in mode factory", mode));
        }
    }
}
