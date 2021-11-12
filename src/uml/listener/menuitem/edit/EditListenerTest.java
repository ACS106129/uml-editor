package uml.listener.menuitem.edit;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

import uml.graphic.component.panel.CanvasPanel;

public class EditListenerTest {

    private final EditListener testEditListener1 = new DeleteListener();
    private final EditListener testEditListener2 = new DeleteListenerStub();
    private final EditListener testEditListener3 = new GroupListener();
    private final EditListener testEditListener4 = new GroupListenerStub();
    private final EditListener testEditListener5 = new RenameListener();
    private final EditListener testEditListener6 = new RenameListenerStub();
    private final EditListener testEditListener7 = new UngroupListener();
    private final EditListener testEditListener8 = new UngroupListenerStub();

    @Test
    public void test_actionPerformed_throws() {
        assertThrows(NullPointerException.class, () -> testEditListener1.actionPerformed(null));
        assertThrows(NullPointerException.class, () -> testEditListener2.actionPerformed(null));
        assertThrows(NullPointerException.class, () -> testEditListener3.actionPerformed(null));
        assertThrows(NullPointerException.class, () -> testEditListener4.actionPerformed(null));
        assertThrows(NullPointerException.class, () -> testEditListener5.actionPerformed(null));
        assertThrows(NullPointerException.class, () -> testEditListener6.actionPerformed(null));
        assertThrows(NullPointerException.class, () -> testEditListener7.actionPerformed(null));
        assertThrows(NullPointerException.class, () -> testEditListener8.actionPerformed(null));
    }

    @Test
    public void test_actionPerformed_no_throws() {
        final ActionEvent testActionEvent = new ActionEvent("testAction", 0, "NoThrows");
        assertDoesNotThrow(() -> testEditListener1.actionPerformed(testActionEvent));
        assertDoesNotThrow(() -> testEditListener2.actionPerformed(testActionEvent));
        assertDoesNotThrow(() -> testEditListener3.actionPerformed(testActionEvent));
        assertDoesNotThrow(() -> testEditListener4.actionPerformed(testActionEvent));
        assertDoesNotThrow(() -> testEditListener5.actionPerformed(testActionEvent));
        assertDoesNotThrow(() -> testEditListener6.actionPerformed(testActionEvent));
        assertDoesNotThrow(() -> testEditListener7.actionPerformed(testActionEvent));
        assertDoesNotThrow(() -> testEditListener8.actionPerformed(testActionEvent));
    }

    @Test
    public void test_invokeCanvasAction_throws() {
        assertThrows(NullPointerException.class, () -> testEditListener1.invokeCanvasAction(null));
        assertThrows(NullPointerException.class, () -> testEditListener2.invokeCanvasAction(null));
        assertThrows(NullPointerException.class, () -> testEditListener3.invokeCanvasAction(null));
        assertThrows(NullPointerException.class, () -> testEditListener4.invokeCanvasAction(null));
        assertThrows(NullPointerException.class, () -> testEditListener5.invokeCanvasAction(null));
        assertThrows(NullPointerException.class, () -> testEditListener6.invokeCanvasAction(null));
        assertThrows(NullPointerException.class, () -> testEditListener7.invokeCanvasAction(null));
        assertThrows(NullPointerException.class, () -> testEditListener8.invokeCanvasAction(null));
    }

    @Test
    public void test_invokeCanvasAction_no_throws() {
        final CanvasPanel testCanvasPanel = new CanvasPanel();
        assertDoesNotThrow(() -> testEditListener1.invokeCanvasAction(testCanvasPanel));
        assertDoesNotThrow(() -> testEditListener2.invokeCanvasAction(testCanvasPanel));
        assertDoesNotThrow(() -> testEditListener3.invokeCanvasAction(testCanvasPanel));
        assertDoesNotThrow(() -> testEditListener4.invokeCanvasAction(testCanvasPanel));
        assertDoesNotThrow(() -> testEditListener5.invokeCanvasAction(testCanvasPanel));
        assertDoesNotThrow(() -> testEditListener6.invokeCanvasAction(testCanvasPanel));
        assertDoesNotThrow(() -> testEditListener7.invokeCanvasAction(testCanvasPanel));
        assertDoesNotThrow(() -> testEditListener8.invokeCanvasAction(testCanvasPanel));
    }
}
