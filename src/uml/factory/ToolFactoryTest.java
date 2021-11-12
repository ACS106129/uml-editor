package uml.factory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import uml.graphic.component.tool.mode.ToolMode;

public class ToolFactoryTest {

    @Test
    public void test_generate_with_correctPathName_no_throws() {
        assertDoesNotThrow(
                () -> ToolFactory.generate("/resources/image/tool/association_line.png", ToolMode.AssociationLine));
        assertDoesNotThrow(
                () -> ToolFactory.generate("/resources/image/tool/class_diagram.png", ToolMode.ClassDiagram));
        assertDoesNotThrow(
                () -> ToolFactory.generate("/resources/image/tool/composition_line.png", ToolMode.CompositionLine));
        assertDoesNotThrow(() -> ToolFactory.generate("/resources/image/tool/generalization_line.png",
                ToolMode.GeneralizationLine));
        assertDoesNotThrow(() -> ToolFactory.generate("/resources/image/tool/select.png", ToolMode.Select));
        assertDoesNotThrow(
                () -> ToolFactory.generate("/resources/image/tool/use_case_diagram.png", ToolMode.UseCaseDiagram));
    }

    @Test
    public void test_generate_with_noExistsPathName_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> ToolFactory.generate("/resources/image/tool/do.jpg", ToolMode.AssociationLine));
        assertThrows(IllegalArgumentException.class,
                () -> ToolFactory.generate("/resources/image/tool/not.png", ToolMode.ClassDiagram));
        assertThrows(IllegalArgumentException.class,
                () -> ToolFactory.generate("/resources/image/tool/exist.pdf", ToolMode.CompositionLine));
        assertThrows(IllegalArgumentException.class,
                () -> ToolFactory.generate("/resources/image/tool/the.docx", ToolMode.GeneralizationLine));
        assertThrows(IllegalArgumentException.class,
                () -> ToolFactory.generate("/resources/image/tool/path.ppt", ToolMode.Select));
        assertThrows(IllegalArgumentException.class,
                () -> ToolFactory.generate("/resources/image/tool/pathname.txt", ToolMode.UseCaseDiagram));
    }
}
