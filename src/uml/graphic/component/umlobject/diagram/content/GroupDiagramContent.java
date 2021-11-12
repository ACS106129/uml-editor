package uml.graphic.component.umlobject.diagram.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GroupDiagramContent extends DiagramContent {

    private final Color groupColor = new Color(150, 150, 150, 127);

    public GroupDiagramContent(final Dimension groupSize) {
        super("group", groupSize);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.setColor(groupColor);
        g.fillRect(0, 0, drawBounds.width, drawBounds.height);
        g.setColor(Color.DARK_GRAY);
        g.drawRect(0, 0, drawBounds.width, drawBounds.height);
    }
}
