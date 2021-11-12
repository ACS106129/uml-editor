package uml;

import javax.swing.SwingUtilities;

import uml.graphic.MainFrame;

public class Launcher {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame("UML Editor", 800, 600));
    }
}
