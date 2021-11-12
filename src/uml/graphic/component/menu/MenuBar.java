package uml.graphic.component.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uml.factory.ListenerFactory;
import uml.listener.type.ListenerType;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        add(getNewMenu("File", ListenerType.Exit));
        add(getNewMenu("Edit", ListenerType.Group, ListenerType.Ungroup, ListenerType.Rename, ListenerType.Delete));
    }

    private JMenu getNewMenu(final String name, final ListenerType... types) {
        final JMenu menu = new JMenu(name);
        for (final ListenerType type : types)
            ListenerFactory.generate(type).addToComponent(menu.add(new JMenuItem(type.toString())));
        return menu;
    }
}
