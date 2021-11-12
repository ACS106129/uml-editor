package uml.listener.tool;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

import uml.listener.Listener;

public class ToolListenerStub extends ComponentAdapter implements Listener, ActionListener {

    @Override
    public void actionPerformed(final ActionEvent e) {
        e.getSource();
    }

    @Override
    public void addToComponent(final Component comp) {
    }
}
