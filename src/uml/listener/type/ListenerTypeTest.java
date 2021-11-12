package uml.listener.type;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ListenerTypeTest {
    @Test
    public void test_toString_returns_itsName() {
        assertEquals("delete", ListenerType.Delete.toString());
        assertEquals("exit", ListenerType.Exit.toString());
        assertEquals("group", ListenerType.Group.toString());
        assertEquals("rename", ListenerType.Rename.toString());
        assertEquals("tool", ListenerType.Tool.toString());
        assertEquals("ungroup", ListenerType.Ungroup.toString());
    }
}
