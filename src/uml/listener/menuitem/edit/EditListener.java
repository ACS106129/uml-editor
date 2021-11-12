package uml.listener.menuitem.edit;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import uml.graphic.MainFrame;
import uml.graphic.component.panel.CanvasPanel;
import uml.listener.menuitem.MenuItemListener;

public abstract class EditListener extends MenuItemListener {

    @Override
    public final void actionPerformed(final ActionEvent e) {
        if (!(e.getSource() instanceof JMenuItem) || !(((JMenuItem) e.getSource()).getParent() instanceof JPopupMenu))
            return;
        final Component comp = ((JPopupMenu) ((JMenuItem) e.getSource()).getParent()).getInvoker();
        if (!(SwingUtilities.getWindowAncestor(comp) instanceof MainFrame))
            return;
        final CanvasPanel cPanel = ((MainFrame) SwingUtilities.getWindowAncestor(comp)).canvasPanel;
        invokeCanvasAction(cPanel);
        cPanel.repaint();
    }

    protected abstract void invokeCanvasAction(final CanvasPanel cPanel);
}
