package uml.listener.menuitem.file;

import java.awt.event.ActionEvent;

import uml.listener.menuitem.MenuItemListener;

public class ExitListenerStub extends MenuItemListener{

    @Override
    public void actionPerformed(final ActionEvent e) {
        e.getSource();
    }
}
