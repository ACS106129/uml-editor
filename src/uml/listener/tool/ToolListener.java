package uml.listener.tool;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import uml.graphic.component.panel.ToolPanel;
import uml.graphic.component.tool.Tool;
import uml.listener.Listener;

public class ToolListener extends ComponentAdapter implements Listener, ActionListener {

    @Override
    public void addToComponent(final Component comp) {
        if (!(comp instanceof Tool))
            return;
        ((Tool) comp).addActionListener(this);
        ((Tool) comp).addComponentListener(this);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (!(e.getSource() instanceof Tool) || !(((Tool) e.getSource()).getParent() instanceof ToolPanel))
            return;
        final Tool tool = (Tool) e.getSource();
        final ToolPanel toolPanel = (ToolPanel) tool.getParent();
        toolPanel.setCurrentMode(tool.mode);
    }

    @Override
    public void componentResized(final ComponentEvent e) {
        if (!(e.getComponent() instanceof Tool))
            return;
        ((Tool) e.getComponent()).resizeImage();
    }
}
