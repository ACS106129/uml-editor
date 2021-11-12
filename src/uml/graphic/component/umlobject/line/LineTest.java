package uml.graphic.component.umlobject.line;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.content.ClassDiagramContent;
import uml.graphic.component.umlobject.diagram.content.UseCaseDiagramContent;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;

public class LineTest {

    private final Line testLine1 = new AssociationLine(new Diagram(10, new Point(), new ClassDiagramContent()),
            DiagramPortPosition.Left);
    private final Line testLine2 = new CompositionLine(new Diagram(10, new Point(), new ClassDiagramContent()),
            DiagramPortPosition.Left);
    private final Line testLine3 = new GeneralizationLine(new Diagram(10, new Point(), new ClassDiagramContent()),
            DiagramPortPosition.Left);
    private final Line testLine4 = new AssociationLineStub();
    private final Line testLine5 = new CompositionLineStub();
    private final Line testLine6 = new GeneralizationLineStub();

    @Test
    public void test_attachDiagram_throws_with_no_destDiagram_present() {
        assertThrows(NoSuchElementException.class, () -> testLine1.attachDiagram());
        assertThrows(NoSuchElementException.class, () -> testLine2.attachDiagram());
        assertThrows(NoSuchElementException.class, () -> testLine3.attachDiagram());
        assertThrows(NoSuchElementException.class, () -> testLine4.attachDiagram());
        assertThrows(NoSuchElementException.class, () -> testLine5.attachDiagram());
        assertThrows(NoSuchElementException.class, () -> testLine6.attachDiagram());
    }

    @Test
    public void test_attachDiagram_with_updateBufferedPoint_and_replaceDestDiagram_no_throws_and_hover_on_the_dest_port() {
        final Diagram destDiagram = new Diagram(100, new Point(100, 100), new UseCaseDiagramContent());
        final Point destPortPos = destDiagram.getPortBounds(Optional.of(DiagramPortPosition.Left)).orElseThrow()
                .getLocation();
        assertDoesNotThrow(() -> testLine1.updateBufferedPoint(destPortPos));
        assertDoesNotThrow(() -> testLine2.updateBufferedPoint(destPortPos));
        assertDoesNotThrow(() -> testLine3.updateBufferedPoint(destPortPos));
        assertDoesNotThrow(() -> testLine4.updateBufferedPoint(destPortPos));
        assertDoesNotThrow(() -> testLine5.updateBufferedPoint(destPortPos));
        assertDoesNotThrow(() -> testLine6.updateBufferedPoint(destPortPos));
        assertDoesNotThrow(() -> testLine1.replaceDestDiagram(destDiagram));
        assertDoesNotThrow(() -> testLine2.replaceDestDiagram(destDiagram));
        assertDoesNotThrow(() -> testLine3.replaceDestDiagram(destDiagram));
        assertDoesNotThrow(() -> testLine4.replaceDestDiagram(destDiagram));
        assertDoesNotThrow(() -> testLine5.replaceDestDiagram(destDiagram));
        assertDoesNotThrow(() -> testLine6.replaceDestDiagram(destDiagram));
        assertDoesNotThrow(() -> testLine1.attachDiagram());
        assertDoesNotThrow(() -> testLine2.attachDiagram());
        assertDoesNotThrow(() -> testLine3.attachDiagram());
        assertDoesNotThrow(() -> testLine4.attachDiagram());
        assertDoesNotThrow(() -> testLine5.attachDiagram());
        assertDoesNotThrow(() -> testLine6.attachDiagram());
        assertTrue(testLine1.isHoverOnDestPort());
        assertTrue(testLine2.isHoverOnDestPort());
        assertTrue(testLine3.isHoverOnDestPort());
        assertTrue(testLine4.isHoverOnDestPort());
        assertTrue(testLine5.isHoverOnDestPort());
        assertTrue(testLine6.isHoverOnDestPort());
    }

    @Test
    public void test_replaceDestDiagram_with_null_no_throws() {
        assertDoesNotThrow(() -> testLine1.replaceDestDiagram(null));
        assertDoesNotThrow(() -> testLine2.replaceDestDiagram(null));
        assertDoesNotThrow(() -> testLine3.replaceDestDiagram(null));
        assertDoesNotThrow(() -> testLine4.replaceDestDiagram(null));
        assertDoesNotThrow(() -> testLine5.replaceDestDiagram(null));
        assertDoesNotThrow(() -> testLine6.replaceDestDiagram(null));
    }

    @Test
    public void test_invokeDetach_no_throws() {
        final Diagram diagram = new Diagram(0, new Point(), new UseCaseDiagramContent());
        assertDoesNotThrow(() -> testLine1.invokeDetach(diagram));
        assertDoesNotThrow(() -> testLine2.invokeDetach(diagram));
        assertDoesNotThrow(() -> testLine3.invokeDetach(diagram));
        assertDoesNotThrow(() -> testLine4.invokeDetach(diagram));
        assertDoesNotThrow(() -> testLine5.invokeDetach(diagram));
        assertDoesNotThrow(() -> testLine6.invokeDetach(diagram));
        assertDoesNotThrow(() -> testLine1.invokeDetach(null));
        assertDoesNotThrow(() -> testLine2.invokeDetach(null));
        assertDoesNotThrow(() -> testLine3.invokeDetach(null));
        assertDoesNotThrow(() -> testLine4.invokeDetach(null));
        assertDoesNotThrow(() -> testLine5.invokeDetach(null));
        assertDoesNotThrow(() -> testLine6.invokeDetach(null));
    }

    @Test
    public void test_getBounds_no_throws() {
        assertDoesNotThrow(() -> testLine1.getBounds());
        assertDoesNotThrow(() -> testLine2.getBounds());
        assertDoesNotThrow(() -> testLine3.getBounds());
        assertDoesNotThrow(() -> testLine4.getBounds());
        assertDoesNotThrow(() -> testLine5.getBounds());
        assertDoesNotThrow(() -> testLine6.getBounds());
    }

    @Test
    public void test_getDestPortPos_no_throws() {
        assertDoesNotThrow(() -> testLine1.getDestPortPos());
        assertDoesNotThrow(() -> testLine2.getDestPortPos());
        assertDoesNotThrow(() -> testLine3.getDestPortPos());
        assertDoesNotThrow(() -> testLine4.getDestPortPos());
        assertDoesNotThrow(() -> testLine5.getDestPortPos());
        assertDoesNotThrow(() -> testLine6.getDestPortPos());
    }

    @Test
    public void test_isHoverOnDestPort_returns_false() {
        assertFalse(testLine1.isHoverOnDestPort());
        assertFalse(testLine2.isHoverOnDestPort());
        assertFalse(testLine3.isHoverOnDestPort());
        assertFalse(testLine4.isHoverOnDestPort());
        assertFalse(testLine5.isHoverOnDestPort());
        assertFalse(testLine6.isHoverOnDestPort());
    }

    @Test
    public void test_paintComponent_and_render_no_throws() {
        final JFrame testFrame = new JFrame();
        testFrame.add(testLine1);
        testFrame.add(testLine2);
        testFrame.add(testLine3);
        testFrame.add(testLine4);
        testFrame.add(testLine5);
        testFrame.add(testLine6);
        testFrame.setVisible(true);
        assertDoesNotThrow(() -> testLine1.paintComponents(testFrame.getGraphics()));
        assertDoesNotThrow(() -> testLine2.paintComponents(testFrame.getGraphics()));
        assertDoesNotThrow(() -> testLine3.paintComponents(testFrame.getGraphics()));
        assertDoesNotThrow(() -> testLine4.paintComponents(testFrame.getGraphics()));
        assertDoesNotThrow(() -> testLine5.paintComponents(testFrame.getGraphics()));
        assertDoesNotThrow(() -> testLine6.paintComponents(testFrame.getGraphics()));
        assertDoesNotThrow(() -> testLine1.render(testFrame.getGraphics(), new Point(), new Point()));
        assertDoesNotThrow(() -> testLine2.render(testFrame.getGraphics(), new Point(), new Point()));
        assertDoesNotThrow(() -> testLine3.render(testFrame.getGraphics(), new Point(), new Point()));
        assertDoesNotThrow(() -> testLine4.render(testFrame.getGraphics(), new Point(), new Point()));
        assertDoesNotThrow(() -> testLine5.render(testFrame.getGraphics(), new Point(), new Point()));
        assertDoesNotThrow(() -> testLine6.render(testFrame.getGraphics(), new Point(), new Point()));
    }
}
