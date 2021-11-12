package uml.graphic.component.panel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import uml.factory.ToolFactory;
import uml.graphic.component.tool.mode.ToolMode;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.content.ClassDiagramContent;
import uml.graphic.component.umlobject.diagram.content.GroupDiagramContent;
import uml.graphic.component.umlobject.diagram.content.UseCaseDiagramContent;

public class CanvasPanelTest {

    @Test
    public void test_getDiagrams_with_addNoneDiagrams_returns_empty() {
        final CanvasPanel cPanel = new CanvasPanel();
        assertTrue(cPanel.getDiagrams().isEmpty());
        cPanel.add(new Component() {
        });
        cPanel.add(new JButton());
        cPanel.add(new JComponent() {
        });
        cPanel.add(new JMenu());
        cPanel.add(new JPanel());
        cPanel.add(assertDoesNotThrow(
                () -> ToolFactory.generate("/resources/image/tool/association_line.png", ToolMode.AssociationLine)));
        cPanel.add(assertDoesNotThrow(
                () -> ToolFactory.generate("/resources/image/tool/class_diagram.png", ToolMode.ClassDiagram)));
        cPanel.add(assertDoesNotThrow(
                () -> ToolFactory.generate("/resources/image/tool/composition_line.png", ToolMode.CompositionLine)));
        cPanel.add(assertDoesNotThrow(() -> ToolFactory.generate("/resources/image/tool/generalization_line.png",
                ToolMode.GeneralizationLine)));
        cPanel.add(assertDoesNotThrow(() -> ToolFactory.generate("/resources/image/tool/select.png", ToolMode.Select)));
        cPanel.add(assertDoesNotThrow(
                () -> ToolFactory.generate("/resources/image/tool/use_case_diagram.png", ToolMode.UseCaseDiagram)));
        assertTrue(cPanel.getDiagrams().isEmpty());
    }

    @Test
    public void test_getDiagrams_with_addDiagrams_returns_sameAsAdded() {
        final CanvasPanel cPanel = new CanvasPanel();
        assertTrue(cPanel.getDiagrams().isEmpty());
        for (int i = 0; i < 100000; ++i) {
            cPanel.add(new Diagram(12, new Point(), new ClassDiagramContent()));
            cPanel.add(new Diagram(12, new Point(), new UseCaseDiagramContent()));
            cPanel.add(new Diagram(12, new Point(), new GroupDiagramContent(new Dimension())));
        }
        assertEquals(300000, cPanel.getDiagrams().size());
    }

    @Test
    public void test_getSelectedDiagrams_with_doDiagramSelect_no_throws() {
        final CanvasPanel cPanel = new CanvasPanel();
        assertTrue(cPanel.getDiagrams().isEmpty());
        for (int i = 0; i < 1000; ++i) {
            cPanel.add(new Diagram(12, new Point(), new ClassDiagramContent()));
            cPanel.add(new Diagram(12, new Point(), new UseCaseDiagramContent()));
            cPanel.add(new Diagram(12, new Point(), new GroupDiagramContent(new Dimension())));
        }
        assertEquals(0, cPanel.getSelectedDiagrams().size());
        assertEquals(3000, cPanel.getDiagrams().size());
        new Random().ints(500, 0, 3000)
                .forEach(i -> assertDoesNotThrow(() -> cPanel.getDiagrams().get(i).setSelect(true)));
    }

    @Test
    public void test_paintChildren_no_throws() {
        final JFrame testFrame = new JFrame();
        final CanvasPanel cPanel = new CanvasPanel();
        testFrame.add(cPanel);
        testFrame.setVisible(true);
        assertTrue(cPanel.getDiagrams().isEmpty());
        assertDoesNotThrow(() -> cPanel.paintChildren(testFrame.getGraphics()));
    }

    @Test
    public void test_setText_with_utf8_no_throws() {
        final CanvasPanel cPanel = new CanvasPanel();
        assertDoesNotThrow(() -> cPanel.setText(StandardCharsets.UTF_8.encode("This is English").toString()));
        assertDoesNotThrow(() -> cPanel.setText(StandardCharsets.UTF_8.encode("這是中文").toString()));
        assertDoesNotThrow(() -> cPanel.setText(StandardCharsets.UTF_8.encode("これは日本語です").toString()));
        assertDoesNotThrow(() -> cPanel.setText(StandardCharsets.UTF_8.encode("これは日本語です").toString()));
    }
}
