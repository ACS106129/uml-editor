package uml.graphic.component.umlobject.diagram.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

public class ClassDiagramContent extends DiagramContent {

    private final Color classColor = new Color(200, 200, 0, 127);

    public ClassDiagramContent() {
        super("class", new Dimension(100, 120));
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.setColor(classColor);
        g.fillRect(0, 0, drawBounds.width, drawBounds.height);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, drawBounds.width, drawBounds.height);
        Arrays.asList(1, 2).forEach(i -> g.drawLine(0, 0 + Math.round(i * drawBounds.height / 3.f),
                (int) drawBounds.getMaxX(), 0 + Math.round(i * drawBounds.height / 3.f)));
    }
}
