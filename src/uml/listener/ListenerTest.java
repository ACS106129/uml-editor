package uml.listener;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import uml.listener.menuitem.edit.DeleteListener;
import uml.listener.menuitem.edit.DeleteListenerStub;
import uml.listener.menuitem.edit.GroupListener;
import uml.listener.menuitem.edit.GroupListenerStub;
import uml.listener.menuitem.edit.RenameListener;
import uml.listener.menuitem.edit.RenameListenerStub;
import uml.listener.menuitem.edit.UngroupListener;
import uml.listener.menuitem.edit.UngroupListenerStub;
import uml.listener.menuitem.file.ExitListener;
import uml.listener.menuitem.file.ExitListenerStub;
import uml.listener.tool.ToolListener;
import uml.listener.tool.ToolListenerStub;

public class ListenerTest {
    private final Listener testListener1 = new DeleteListener();
    private final Listener testListener2 = new DeleteListenerStub();
    private final Listener testListener3 = new GroupListener();
    private final Listener testListener4 = new GroupListenerStub();
    private final Listener testListener5 = new RenameListener();
    private final Listener testListener6 = new RenameListenerStub();
    private final Listener testListener7 = new UngroupListener();
    private final Listener testListener8 = new UngroupListenerStub();
    private final Listener testListener9 = new ExitListener();
    private final Listener testListener10 = new ExitListenerStub();
    private final Listener testListener11 = new ToolListener();
    private final Listener testListener12 = new ToolListenerStub();

    @Test
    public void test_addToComponent_no_throws() {
        final JPanel testPanel = new JPanel();
        assertDoesNotThrow(() -> testListener1.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener2.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener3.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener4.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener5.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener6.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener7.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener8.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener9.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener10.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener11.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener12.addToComponent(testPanel));
        assertDoesNotThrow(() -> testListener1.addToComponent(null));
        assertDoesNotThrow(() -> testListener2.addToComponent(null));
        assertDoesNotThrow(() -> testListener3.addToComponent(null));
        assertDoesNotThrow(() -> testListener4.addToComponent(null));
        assertDoesNotThrow(() -> testListener5.addToComponent(null));
        assertDoesNotThrow(() -> testListener6.addToComponent(null));
        assertDoesNotThrow(() -> testListener7.addToComponent(null));
        assertDoesNotThrow(() -> testListener8.addToComponent(null));
        assertDoesNotThrow(() -> testListener9.addToComponent(null));
        assertDoesNotThrow(() -> testListener10.addToComponent(null));
        assertDoesNotThrow(() -> testListener11.addToComponent(null));
        assertDoesNotThrow(() -> testListener12.addToComponent(null));
    }
}
