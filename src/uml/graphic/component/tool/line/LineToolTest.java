package uml.graphic.component.tool.line;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.content.ClassDiagramContentStub;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.Line;

public class LineToolTest {

    private final LineTool testLineTool1 = new AssociationLineTool("/resources/image/tool/association_line.png");
    private final LineTool testLineTool2 = new CompositionLineTool("/resources/image/tool/use_case_diagram.png");
    private final LineTool testLineTool3 = new GeneralizationLineTool("/resources/image/tool/generalization_line.png");
    private final LineTool testLineTool4 = new AssociationLineToolStub();
    private final LineTool testLineTool5 = new CompositionLineToolStub();
    private final LineTool testLineTool6 = new GeneralizationLineToolStub();

    @Test
    public void test_drawObject_no_throws() {
        assertDoesNotThrow(
                () -> testLineTool1.drawObject(new MouseEvent(testLineTool1, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testLineTool2.drawObject(new MouseEvent(testLineTool2, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testLineTool3.drawObject(new MouseEvent(testLineTool3, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testLineTool4.drawObject(new MouseEvent(testLineTool4, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testLineTool5.drawObject(new MouseEvent(testLineTool5, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testLineTool6.drawObject(new MouseEvent(testLineTool6, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
    }

    @Test
    public void test_drawObject_throws() {
        assertThrows(NullPointerException.class, () -> testLineTool1.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testLineTool2.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testLineTool3.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testLineTool4.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testLineTool5.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testLineTool6.drawObject(null, null));
    }

    @Test
    public void test_generateLine_with_rangeOfGenerating_should_exists() {
        IntStream.rangeClosed(0, 10000).forEach(i -> {
            assertInstanceOf(Line.class, testLineTool1.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Left));
            assertInstanceOf(Line.class, testLineTool2.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Top));
            assertInstanceOf(Line.class, testLineTool3.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Right));
            assertInstanceOf(Line.class, testLineTool4.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Bottom));
            assertInstanceOf(Line.class, testLineTool5.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Left));
            assertInstanceOf(Line.class, testLineTool6.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Top));
        });
    }

    @Test
    public void test_generateLine_with_rangeOfGenerating_no_throws() {
        IntStream.rangeClosed(0, 10000).forEach(i -> {
            assertDoesNotThrow(() -> testLineTool1.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Left));
            assertDoesNotThrow(() -> testLineTool2.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Top));
            assertDoesNotThrow(() -> testLineTool3.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Right));
            assertDoesNotThrow(() -> testLineTool4.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Bottom));
            assertDoesNotThrow(() -> testLineTool5.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Left));
            assertDoesNotThrow(() -> testLineTool6.generateLine(
                    new Diagram(i, new Point(i, i), new ClassDiagramContentStub()), DiagramPortPosition.Top));
        });
    }
}
