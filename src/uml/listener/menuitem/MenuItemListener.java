package uml.listener.menuitem;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JMenuItem;

import uml.listener.Listener;

public abstract class MenuItemListener implements Listener, ActionListener {

    @Override
    public void addToComponent(final Component comp) {
        if (!(comp instanceof JMenuItem))
            return;
        ((AbstractButton) comp).addActionListener(this);
    }
}
