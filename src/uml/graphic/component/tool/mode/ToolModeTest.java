package uml.graphic.component.tool.mode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ToolModeTest {

    @Test
    public void test_toString_returns_itsName() {
        assertEquals("Association Line", ToolMode.AssociationLine.toString());
        assertEquals("Class Diagram", ToolMode.ClassDiagram.toString());
        assertEquals("Composition Line", ToolMode.CompositionLine.toString());
        assertEquals("Generalization Line", ToolMode.GeneralizationLine.toString());
        assertEquals("Select", ToolMode.Select.toString());
        assertEquals("Use Case Diagram", ToolMode.UseCaseDiagram.toString());
    }
}
