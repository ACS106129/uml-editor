package uml.graphic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import uml.graphic.component.menu.MenuBar;
import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.panel.ToolPanel;

public class MainFrame extends JFrame {

    private static boolean isInstance = false;
    public final CanvasPanel canvasPanel;
    public final ToolPanel toolPanel;

    public MainFrame(final String name, final int width, final int height) {
        super(name);
        if (isInstance)
            throw new IllegalAccessError("Main Frame is already instances!");
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(width, height));
        setLayout(new BorderLayout());
        setJMenuBar(new MenuBar());
        setLocationRelativeTo(null);
        setBounds((screenSize.width - width) / 2, (screenSize.height - height) / 2, width, height);
        canvasPanel = new CanvasPanel();
        toolPanel = new ToolPanel("/resources/tool_listmap");
        add(toolPanel, BorderLayout.LINE_START);
        add(canvasPanel);
        setVisible(true);
        setAlwaysOnTop(true);
        setAlwaysOnTop(false);
        isInstance = true;
    }
}
