package uml.graphic.component.umlobject.diagram.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class UseCaseDiagramContent extends DiagramContent {

    private final Color useCaseColor = new Color(0, 200, 0, 127);

    public UseCaseDiagramContent() {
        super("use case", new Dimension(100, 70));
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.setColor(useCaseColor);
        g.fillOval(0, 0, drawBounds.width, drawBounds.height);
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, drawBounds.width, drawBounds.height);
    }
}