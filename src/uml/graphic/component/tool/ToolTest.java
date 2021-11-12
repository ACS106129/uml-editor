package uml.graphic.component.tool;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.awt.event.MouseEvent;

import org.junit.jupiter.api.Test;

import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.tool.diagram.ClassDiagramTool;
import uml.graphic.component.tool.diagram.ClassDiagramToolStub;
import uml.graphic.component.tool.diagram.UseCaseDiagramTool;
import uml.graphic.component.tool.diagram.UseCaseDiagramToolStub;
import uml.graphic.component.tool.line.AssociationLineTool;
import uml.graphic.component.tool.line.AssociationLineToolStub;
import uml.graphic.component.tool.line.CompositionLineTool;
import uml.graphic.component.tool.line.CompositionLineToolStub;
import uml.graphic.component.tool.line.GeneralizationLineTool;
import uml.graphic.component.tool.line.GeneralizationLineToolStub;
import uml.graphic.component.tool.select.SelectTool;
import uml.graphic.component.tool.select.SelectToolStub;

public class ToolTest {

    private final Tool testTool1 = new AssociationLineTool("/resources/image/tool/association_line.png");
    private final Tool testTool2 = new CompositionLineTool("/resources/image/tool/use_case_diagram.png");
    private final Tool testTool3 = new GeneralizationLineTool("/resources/image/tool/generalization_line.png");
    private final Tool testTool4 = new ClassDiagramTool("/resources/image/tool/class_diagram.png");
    private final Tool testTool5 = new UseCaseDiagramTool("/resources/image/tool/use_case_diagram.png");
    private final Tool testTool6 = new SelectTool("/resources/image/tool/select.png");
    private final Tool testTool7 = new ClassDiagramToolStub();
    private final Tool testTool8 = new UseCaseDiagramToolStub();
    private final Tool testTool9 = new AssociationLineToolStub();
    private final Tool testTool10 = new CompositionLineToolStub();
    private final Tool testTool11 = new GeneralizationLineToolStub();
    private final Tool testTool12 = new SelectToolStub();

    @Test
    public void test_drawObject_no_throws() {
        assertDoesNotThrow(
                () -> testTool1.drawObject(new MouseEvent(testTool1, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool2.drawObject(new MouseEvent(testTool2, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool3.drawObject(new MouseEvent(testTool3, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool4.drawObject(new MouseEvent(testTool4, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool5.drawObject(new MouseEvent(testTool5, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool6.drawObject(new MouseEvent(testTool6, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool7.drawObject(new MouseEvent(testTool1, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool8.drawObject(new MouseEvent(testTool2, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool9.drawObject(new MouseEvent(testTool3, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool10.drawObject(new MouseEvent(testTool4, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool11.drawObject(new MouseEvent(testTool5, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
        assertDoesNotThrow(
                () -> testTool12.drawObject(new MouseEvent(testTool6, 0, 0, 0, 0, 0, 0, false, 0), new CanvasPanel()));
    }

    @Test
    public void test_drawObject_throws() {
        assertThrows(NullPointerException.class, () -> testTool1.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool2.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool3.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool4.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool5.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool6.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool7.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool8.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool9.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool10.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool11.drawObject(null, null));
        assertThrows(NullPointerException.class, () -> testTool12.drawObject(null, null));
    }

    @Test
    public void test_ResizeImage_no_throws() {
        assertDoesNotThrow(() -> testTool1.resizeImage());
        assertDoesNotThrow(() -> testTool2.resizeImage());
        assertDoesNotThrow(() -> testTool3.resizeImage());
        assertDoesNotThrow(() -> testTool4.resizeImage());
        assertDoesNotThrow(() -> testTool5.resizeImage());
        assertDoesNotThrow(() -> testTool6.resizeImage());
        assertDoesNotThrow(() -> testTool7.resizeImage());
        assertDoesNotThrow(() -> testTool8.resizeImage());
        assertDoesNotThrow(() -> testTool9.resizeImage());
        assertDoesNotThrow(() -> testTool10.resizeImage());
        assertDoesNotThrow(() -> testTool11.resizeImage());
        assertDoesNotThrow(() -> testTool12.resizeImage());
    }

    @Test
    public void test_SetSelected_no_throws() {
        assertDoesNotThrow(() -> testTool1.setSelected(true));
        assertDoesNotThrow(() -> testTool1.setSelected(false));
        assertDoesNotThrow(() -> testTool2.setSelected(true));
        assertDoesNotThrow(() -> testTool2.setSelected(false));
        assertDoesNotThrow(() -> testTool3.setSelected(true));
        assertDoesNotThrow(() -> testTool3.setSelected(false));
        assertDoesNotThrow(() -> testTool4.setSelected(true));
        assertDoesNotThrow(() -> testTool4.setSelected(false));
        assertDoesNotThrow(() -> testTool5.setSelected(true));
        assertDoesNotThrow(() -> testTool5.setSelected(false));
        assertDoesNotThrow(() -> testTool6.setSelected(true));
        assertDoesNotThrow(() -> testTool6.setSelected(false));
        assertDoesNotThrow(() -> testTool7.setSelected(true));
        assertDoesNotThrow(() -> testTool7.setSelected(false));
        assertDoesNotThrow(() -> testTool8.setSelected(true));
        assertDoesNotThrow(() -> testTool8.setSelected(false));
        assertDoesNotThrow(() -> testTool9.setSelected(true));
        assertDoesNotThrow(() -> testTool9.setSelected(false));
        assertDoesNotThrow(() -> testTool10.setSelected(true));
        assertDoesNotThrow(() -> testTool10.setSelected(false));
        assertDoesNotThrow(() -> testTool11.setSelected(true));
        assertDoesNotThrow(() -> testTool11.setSelected(false));
        assertDoesNotThrow(() -> testTool12.setSelected(true));
        assertDoesNotThrow(() -> testTool12.setSelected(false));
    }
}
