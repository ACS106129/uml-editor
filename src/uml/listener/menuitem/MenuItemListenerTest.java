package uml.listener.menuitem;

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

public class MenuItemListenerTest {

    private final MenuItemListener testMenuListener1 = new DeleteListener();
    private final MenuItemListener testMenuListener2 = new DeleteListenerStub();
    private final MenuItemListener testMenuListener3 = new GroupListener();
    private final MenuItemListener testMenuListener4 = new GroupListenerStub();
    private final MenuItemListener testMenuListener5 = new RenameListener();
    private final MenuItemListener testMenuListener6 = new RenameListenerStub();
    private final MenuItemListener testMenuListener7 = new UngroupListener();
    private final MenuItemListener testMenuListener8 = new UngroupListenerStub();
    private final MenuItemListener testMenuListener9 = new ExitListener();
    private final MenuItemListener testMenuListener10 = new ExitListenerStub();

    @Test
    public void test_addToComponent_no_throws() {
        final JPanel testPanel = new JPanel();
        assertDoesNotThrow(() -> testMenuListener1.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener2.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener3.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener4.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener5.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener6.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener7.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener8.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener9.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener10.addToComponent(testPanel));
        assertDoesNotThrow(() -> testMenuListener1.addToComponent(null));
        assertDoesNotThrow(() -> testMenuListener2.addToComponent(null));
        assertDoesNotThrow(() -> testMenuListener3.addToComponent(null));
        assertDoesNotThrow(() -> testMenuListener4.addToComponent(null));
        assertDoesNotThrow(() -> testMenuListener5.addToComponent(null));
        assertDoesNotThrow(() -> testMenuListener6.addToComponent(null));
        assertDoesNotThrow(() -> testMenuListener7.addToComponent(null));
        assertDoesNotThrow(() -> testMenuListener8.addToComponent(null));
        assertDoesNotThrow(() -> testMenuListener9.addToComponent(null));
        assertDoesNotThrow(() -> testMenuListener10.addToComponent(null));
    }
}
