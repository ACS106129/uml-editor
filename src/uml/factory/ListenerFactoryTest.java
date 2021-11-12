package uml.factory;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import uml.listener.menuitem.edit.DeleteListener;
import uml.listener.menuitem.edit.GroupListener;
import uml.listener.menuitem.edit.RenameListener;
import uml.listener.menuitem.edit.UngroupListener;
import uml.listener.menuitem.file.ExitListener;
import uml.listener.tool.ToolListener;
import uml.listener.type.ListenerType;

public class ListenerFactoryTest {

    @Test
    public void test_generate() {
        assertInstanceOf(DeleteListener.class, ListenerFactory.generate(ListenerType.Delete));
        assertInstanceOf(ExitListener.class, ListenerFactory.generate(ListenerType.Exit));
        assertInstanceOf(GroupListener.class, ListenerFactory.generate(ListenerType.Group));
        assertInstanceOf(RenameListener.class, ListenerFactory.generate(ListenerType.Rename));
        assertInstanceOf(ToolListener.class, ListenerFactory.generate(ListenerType.Tool));
        assertInstanceOf(UngroupListener.class, ListenerFactory.generate(ListenerType.Ungroup));
        assertThrows(NullPointerException.class, () -> ListenerFactory.generate(null));
    }
}
