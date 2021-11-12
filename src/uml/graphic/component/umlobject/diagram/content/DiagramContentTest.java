package uml.graphic.component.umlobject.diagram.content;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Dimension;

import org.junit.jupiter.api.Test;

public class DiagramContentTest {
    final DiagramContent testContent1 = new ClassDiagramContent();
    final DiagramContent testContent2 = new GroupDiagramContent(new Dimension(500, 500));
    final DiagramContent testContent3 = new UseCaseDiagramContent();
    final DiagramContent testContent4 = new ClassDiagramContentStub();
    final DiagramContent testContent5 = new GroupDiagramContentStub();
    final DiagramContent testContent6 = new UseCaseDiagramContentStub();

    @Test
    public void test_getText_return_asSetName() {
        assertEquals("class", testContent1.getText());
        assertEquals("group", testContent2.getText());
        assertEquals("use case", testContent3.getText());
        assertEquals("class", testContent4.getText());
        assertEquals("group", testContent5.getText());
        assertEquals("use case", testContent6.getText());
    }

    @Test
    public void test_rename_nullOrExistNewName_no_throws() {
        assertDoesNotThrow(() -> testContent1.rename("test1"));
        assertDoesNotThrow(() -> testContent1.rename(null));
        assertDoesNotThrow(() -> testContent2.rename("test2"));
        assertDoesNotThrow(() -> testContent2.rename(null));
        assertDoesNotThrow(() -> testContent3.rename("test3"));
        assertDoesNotThrow(() -> testContent3.rename(null));
        assertDoesNotThrow(() -> testContent4.rename("test4"));
        assertDoesNotThrow(() -> testContent4.rename(null));
        assertDoesNotThrow(() -> testContent5.rename("test5"));
        assertDoesNotThrow(() -> testContent5.rename(null));
        assertDoesNotThrow(() -> testContent6.rename("test6"));
        assertDoesNotThrow(() -> testContent6.rename(null));
    }

    @Test
    public void test_toString_contains_Content_string() {
        assertTrue(testContent1.toString().contains("Content"));
        assertTrue(testContent2.toString().contains("Content"));
        assertTrue(testContent3.toString().contains("Content"));
        assertTrue(testContent4.toString().contains("Content"));
        assertTrue(testContent5.toString().contains("Content"));
        assertTrue(testContent6.toString().contains("Content"));
    }
}
