package uml.graphic.component.umlobject.diagram.content;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import uml.graphic.component.umlobject.UMLObject;

public abstract class DiagramContent extends UMLObject {

    private final JLabel nameLabel;
    protected final Rectangle drawBounds;

    protected DiagramContent(final String labelName, final Dimension size) {
        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, size.width, size.height);
        drawBounds = new Rectangle(0, 0, getBounds().width - 1, getBounds().height - 1);
        nameLabel = new JLabel(labelName, SwingConstants.CENTER);
        nameLabel.setSize(size);
        add(nameLabel);
    }

    public void rename(final String name) {
        nameLabel.setText(name);
    }

    public String getText() {
        return nameLabel.getText();
    }

    @Override
    public String toString() {
        return "[Content - " + getBounds() + "]";
    }
}
