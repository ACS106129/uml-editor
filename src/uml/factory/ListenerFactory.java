package uml.factory;

import uml.listener.Listener;
import uml.listener.menuitem.edit.DeleteListener;
import uml.listener.menuitem.edit.GroupListener;
import uml.listener.menuitem.edit.RenameListener;
import uml.listener.menuitem.edit.UngroupListener;
import uml.listener.menuitem.file.ExitListener;
import uml.listener.tool.ToolListener;
import uml.listener.type.ListenerType;

public class ListenerFactory {

    private ListenerFactory() {
    }

    public static Listener generate(final ListenerType type) {
        switch (type) {
        case Exit:
            return new ExitListener();
        case Group:
            return new GroupListener();
        case Ungroup:
            return new UngroupListener();
        case Rename:
            return new RenameListener();
        case Delete:
            return new DeleteListener();
        case Tool:
            return new ToolListener();
        default:
            throw new IllegalArgumentException(String.format("Wrong listener type: %d in listener factory", type));
        }
    }
}
