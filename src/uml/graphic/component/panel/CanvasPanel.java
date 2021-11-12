package uml.graphic.component.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uml.graphic.MainFrame;
import uml.graphic.component.umlobject.diagram.Diagram;

public class CanvasPanel extends JPanel {

    private final Color selectedRectFillColor = new Color(0, 0, 255, 30);
    private final Color selectedRectOutlineColor = new Color(0, 0, 255, 127);
    private final JLabel modeInfoLabel = new JLabel();
    public final Rectangle selectedRect = new Rectangle();

    public CanvasPanel() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLoweredSoftBevelBorder());
        modeInfoLabel.setBounds(10, 0, 200, 30);
        add(modeInfoLabel);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent e) {
                dispatchMouseEventToToolPanel(e);
            }

            @Override
            public void mouseReleased(final MouseEvent e) {
                dispatchMouseEventToToolPanel(e);
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(final MouseEvent e) {
                dispatchMouseEventToToolPanel(e);
            }
        });
    }

    public void setText(final String text) {
        modeInfoLabel.setText(text);
    }

    public List<Diagram> getDiagrams() {
        return Arrays.asList(getComponents()).stream().filter(Diagram.class::isInstance).map(Diagram.class::cast)
                .collect(Collectors.toList());
    }

    public List<Diagram> getSelectedDiagrams() {
        return getDiagrams().stream().filter(d -> d.isSelected()).collect(Collectors.toList());
    }

    @Override
    protected void paintChildren(final Graphics g) {
        super.paintChildren(g);
        g.setColor(selectedRectFillColor);
        g.fillRect(selectedRect.x, selectedRect.y, selectedRect.width, selectedRect.height);
        g.setColor(selectedRectOutlineColor);
        g.drawRect(selectedRect.x, selectedRect.y, selectedRect.width - 1, selectedRect.height - 1);
    }

    private void dispatchMouseEventToToolPanel(final MouseEvent e) {
        if (!(SwingUtilities.getWindowAncestor(this) instanceof MainFrame))
            return;
        ((MainFrame) SwingUtilities.getWindowAncestor(this)).toolPanel.invokeDraw(e, this);
    }
}
