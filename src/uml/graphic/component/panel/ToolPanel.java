package uml.graphic.component.panel;

import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import af.swing.layout.AfYLayout;
import uml.factory.ToolFactory;
import uml.graphic.MainFrame;
import uml.graphic.component.tool.Tool;
import uml.graphic.component.tool.mode.ToolMode;

public class ToolPanel extends JPanel {

    private Optional<ToolMode> currentMode = Optional.empty();
    private boolean isAbleToDraw = false;

    public ToolPanel(final String path) {
        setLayout(new AfYLayout());
        try (final Scanner myReader = new Scanner(getClass().getResourceAsStream(path), "UTF-8")) {
            int i = 0;
            while (myReader.hasNextLine())
                add(ToolFactory.generate(myReader.next(), ToolMode.values()[i++]));
        }
    }

    public void setCurrentMode(final ToolMode newMode) {
        final Optional<ToolMode> optNewMode = Optional.of(newMode);
        if (currentMode == optNewMode)
            return;
        getTool(currentMode).ifPresent(t -> t.setSelected(false));
        // apply new tool mode value
        getTool(optNewMode).ifPresent(t -> t.setSelected(true));
        if (!(SwingUtilities.getWindowAncestor(this) instanceof MainFrame))
            return;
        final CanvasPanel cPanel = ((MainFrame) SwingUtilities.getWindowAncestor(this)).canvasPanel;
        cPanel.setText("Mode: " + newMode);
        // deselect dragrams when tool mode changed
        cPanel.getSelectedDiagrams().forEach(d -> d.setSelect(false));
        currentMode = optNewMode;
    }

    public void invokeDraw(final MouseEvent e, final CanvasPanel cPanel) {
        getTool(currentMode).ifPresent(t -> {
            // determine if left mouse button, true will let tool start to draw
            if (e.getID() == MouseEvent.MOUSE_PRESSED && SwingUtilities.isLeftMouseButton(e))
                isAbleToDraw = true;
            else if (!isAbleToDraw)
                return;
            // filter right and middle mouse button intervention
            else if (e.getButton() != MouseEvent.NOBUTTON && !SwingUtilities.isLeftMouseButton(e))
                return;
            // end tool drawing when left mouse released
            else if (e.getID() == MouseEvent.MOUSE_RELEASED)
                isAbleToDraw = false;
            t.drawObject(e, cPanel);
            cPanel.repaint();
        });
    }

    private Optional<Tool> getTool(final Optional<ToolMode> mode) {
        return mode.flatMap(unwarpMode -> Arrays.asList(getComponents()).stream().filter(Tool.class::isInstance)
                .map(Tool.class::cast).filter(t -> unwarpMode == t.mode).findFirst());
    }
}
