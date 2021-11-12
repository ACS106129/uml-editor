package uml.graphic.component.umlobject.diagram;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import uml.graphic.component.umlobject.diagram.content.ClassDiagramContentStub;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.AssociationLineStub;
import uml.graphic.component.umlobject.line.Line;

public class DiagramTest {

    private final Diagram testDiagram1 = new Diagram(100, new Point(100, 100), new ClassDiagramContentStub());
    private final Diagram testDiagram2 = new DiagramStub();
    private final Diagram testDiagram3 = new GroupDiagram(Arrays.asList(testDiagram1, testDiagram2));
    private final Diagram testDiagram4 = new GroupDiagramStub(Arrays.asList(testDiagram1, testDiagram2));

    @Test
    public void test_attach_detach_Lines_no_throws_and_getAttachedLine_returns_sameAsAttached() {
        final Line testline = new AssociationLineStub();
        assertDoesNotThrow(() -> testDiagram1.attachLine(testline, DiagramPortPosition.Left));
        assertDoesNotThrow(() -> testDiagram2.attachLine(testline, DiagramPortPosition.Left));
        assertDoesNotThrow(() -> testDiagram3.attachLine(testline, DiagramPortPosition.Left));
        assertDoesNotThrow(() -> testDiagram4.attachLine(testline, DiagramPortPosition.Left));
        assertEquals(1, testDiagram1.getAttachedLines().size());
        assertEquals(1, testDiagram2.getAttachedLines().size());
        assertEquals(1, testDiagram3.getAttachedLines().size());
        assertEquals(1, testDiagram4.getAttachedLines().size());
        assertDoesNotThrow(() -> testDiagram1.detachLine(testline));
        assertDoesNotThrow(() -> testDiagram2.detachLine(testline));
        assertDoesNotThrow(() -> testDiagram3.detachLine(testline));
        assertDoesNotThrow(() -> testDiagram4.detachLine(testline));
        assertEquals(0, testDiagram1.getAttachedLines().size());
        assertEquals(0, testDiagram2.getAttachedLines().size());
        assertEquals(0, testDiagram3.getAttachedLines().size());
        assertEquals(0, testDiagram4.getAttachedLines().size());
        IntStream.rangeClosed(1, 10000).forEach(i -> {
            assertDoesNotThrow(() -> testDiagram1.attachLine(new AssociationLineStub(), DiagramPortPosition.Left));
            assertDoesNotThrow(() -> testDiagram2.attachLine(new AssociationLineStub(), DiagramPortPosition.Left));
            assertDoesNotThrow(() -> testDiagram3.attachLine(new AssociationLineStub(), DiagramPortPosition.Left));
            assertDoesNotThrow(() -> testDiagram4.attachLine(new AssociationLineStub(), DiagramPortPosition.Left));
            assertEquals(i, testDiagram1.getAttachedLines().size());
            assertEquals(i, testDiagram2.getAttachedLines().size());
            assertEquals(i, testDiagram3.getAttachedLines().size());
            assertEquals(i, testDiagram4.getAttachedLines().size());
        });
        assertDoesNotThrow(() -> testDiagram1.detachAllLines());
        assertDoesNotThrow(() -> testDiagram2.detachAllLines());
        assertDoesNotThrow(() -> testDiagram3.detachAllLines());
        assertDoesNotThrow(() -> testDiagram4.detachAllLines());
        assertEquals(0, testDiagram1.getAttachedLines().size());
        assertEquals(0, testDiagram2.getAttachedLines().size());
        assertEquals(0, testDiagram3.getAttachedLines().size());
        assertEquals(0, testDiagram4.getAttachedLines().size());
    }

    @Test
    public void test_getBounds_no_throws() {
        assertDoesNotThrow(() -> testDiagram1.getBounds());
        assertDoesNotThrow(() -> testDiagram2.getBounds());
        assertDoesNotThrow(() -> testDiagram3.getBounds());
        assertDoesNotThrow(() -> testDiagram4.getBounds());
    }

    @Test
    public void test_getContentBounds_no_throws() {
        assertDoesNotThrow(() -> testDiagram1.getContentBounds());
        assertDoesNotThrow(() -> testDiagram2.getContentBounds());
        assertDoesNotThrow(() -> testDiagram3.getContentBounds());
        assertDoesNotThrow(() -> testDiagram4.getContentBounds());
    }

    @Test
    public void test_getPortBounds_no_throws() {
        for (final DiagramPortPosition port : DiagramPortPosition.values()) {
            assertDoesNotThrow(() -> testDiagram1.getPortBounds(Optional.of(port)));
            assertDoesNotThrow(() -> testDiagram2.getPortBounds(Optional.of(port)));
            assertDoesNotThrow(() -> testDiagram3.getPortBounds(Optional.of(port)));
            assertDoesNotThrow(() -> testDiagram4.getPortBounds(Optional.of(port)));
        }
        assertDoesNotThrow(() -> testDiagram1.getPortBounds(Optional.ofNullable(null)));
        assertDoesNotThrow(() -> testDiagram2.getPortBounds(Optional.ofNullable(null)));
        assertDoesNotThrow(() -> testDiagram3.getPortBounds(Optional.ofNullable(null)));
        assertDoesNotThrow(() -> testDiagram4.getPortBounds(Optional.ofNullable(null)));
    }

    @Test
    public void test_getPortBounds_throws() {
        assertThrows(NullPointerException.class, () -> testDiagram1.getPortBounds(null));
        assertThrows(NullPointerException.class, () -> testDiagram2.getPortBounds(null));
        assertThrows(NullPointerException.class, () -> testDiagram3.getPortBounds(null));
        assertThrows(NullPointerException.class, () -> testDiagram4.getPortBounds(null));
    }

    @Test
    public void test_getPortPositionByContains_no_throws() {
        assertDoesNotThrow(() -> testDiagram1.getPortPositionByContains(new Point()));
        assertDoesNotThrow(() -> testDiagram2.getPortPositionByContains(new Point()));
        assertDoesNotThrow(() -> testDiagram3.getPortPositionByContains(new Point()));
        assertDoesNotThrow(() -> testDiagram4.getPortPositionByContains(new Point()));
    }

    @Test
    public void test_getPortPositionByContains_throws() {
        assertThrows(NullPointerException.class, () -> testDiagram1.getPortPositionByContains(null));
        assertThrows(NullPointerException.class, () -> testDiagram2.getPortPositionByContains(null));
        assertThrows(NullPointerException.class, () -> testDiagram3.getPortPositionByContains(null));
        assertThrows(NullPointerException.class, () -> testDiagram4.getPortPositionByContains(null));
    }

    @Test
    public void test_selecting_no_throws_and_returns_sameAsSelectedOrNot() {
        assertDoesNotThrow(() -> testDiagram1.setSelect(true));
        assertDoesNotThrow(() -> testDiagram2.setSelect(true));
        assertDoesNotThrow(() -> testDiagram3.setSelect(true));
        assertDoesNotThrow(() -> testDiagram4.setSelect(true));
        assertTrue(testDiagram1.isSelected());
        assertTrue(testDiagram2.isSelected());
        assertTrue(testDiagram3.isSelected());
        assertTrue(testDiagram4.isSelected());
        assertDoesNotThrow(() -> testDiagram1.setSelect(false));
        assertDoesNotThrow(() -> testDiagram2.setSelect(false));
        assertDoesNotThrow(() -> testDiagram3.setSelect(false));
        assertDoesNotThrow(() -> testDiagram4.setSelect(false));
        assertFalse(testDiagram1.isSelected());
        assertFalse(testDiagram2.isSelected());
        assertFalse(testDiagram3.isSelected());
        assertFalse(testDiagram4.isSelected());
    }

    @Test
    public void test_rename_no_throws_and_use_getText_returns_sameAsRenamed() {
        assertDoesNotThrow(() -> testDiagram1.rename("test1"));
        assertDoesNotThrow(() -> testDiagram2.rename("test2"));
        assertDoesNotThrow(() -> testDiagram3.rename("test3"));
        assertDoesNotThrow(() -> testDiagram4.rename("test4"));
        assertEquals("test1", testDiagram1.getText());
        assertEquals("test2", testDiagram2.getText());
        assertEquals("test3", testDiagram3.getText());
        assertEquals("test4", testDiagram4.getText());
    }

    @Test
    public void test_toString_no_throws() {
        assertDoesNotThrow(() -> testDiagram1.toString());
        assertDoesNotThrow(() -> testDiagram2.toString());
        assertDoesNotThrow(() -> testDiagram3.toString());
        assertDoesNotThrow(() -> testDiagram4.toString());
    }
}
