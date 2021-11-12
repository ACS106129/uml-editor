package uml.graphic.component.tool.diagram;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.umlobject.diagram.Diagram;

public class DiagramToolTest {

    private final DiagramTool testDiagramTool1 = new ClassDiagramTool("/resources/image/tool/class_diagram.png");
    private final DiagramTool testDiagramTool2 = new UseCaseDiagramTool("/resources/image/tool/use_case_diagram.png");
    private final DiagramTool testDiagramTool3 = new ClassDiagramToolStub();
    private final DiagramTool testDiagramTool4 = new UseCaseDiagramToolStub();

    @Test
    public void test_drawObject_no_throws() {
        assertDoesNotThrow(
                () -> testDiagramTool1.drawObject(new MouseEvent(testDiagramTool1, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testDiagramTool2.drawObject(new MouseEvent(testDiagramTool2, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testDiagramTool3.drawObject(new MouseEvent(testDiagramTool3, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testDiagramTool4.drawObject(new MouseEvent(testDiagramTool3, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
    }

    @Test
    public void test_drawObject_throws() {
        assertThrows(NullPointerException.class, () -> testDiagramTool1.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testDiagramTool2.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testDiagramTool3.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testDiagramTool4.drawObject(null, null));
    }

    @Test
    public void test_generateDiagram_with_rangeOfGenerating_should_exists() {
        IntStream.rangeClosed(0, 100000).forEach(i -> {
            assertInstanceOf(Diagram.class, testDiagramTool1.generateDiagram(i, new Point(i, i)));
            assertInstanceOf(Diagram.class, testDiagramTool2.generateDiagram(i, new Point(i, i)));
            assertInstanceOf(Diagram.class, testDiagramTool3.generateDiagram(i, new Point(i, i)));
            assertInstanceOf(Diagram.class, testDiagramTool4.generateDiagram(i, new Point(i, i)));
        });
    }

    @Test
    public void test_generateDiagram_with_rangeOfGenerating_no_throws() {
        IntStream.rangeClosed(0, 100000).forEach(i -> {
            assertDoesNotThrow(() -> testDiagramTool1.generateDiagram(i, new Point(i, i)));
            assertDoesNotThrow(() -> testDiagramTool2.generateDiagram(i, new Point(i, i)));
            assertDoesNotThrow(() -> testDiagramTool3.generateDiagram(i, new Point(i, i)));
            assertDoesNotThrow(() -> testDiagramTool4.generateDiagram(i, new Point(i, i)));
        });
    }
}
