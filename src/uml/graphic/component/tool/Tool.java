package uml.graphic.component.tool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import uml.factory.ListenerFactory;
import uml.graphic.component.panel.CanvasPanel;
import uml.graphic.component.tool.mode.ToolMode;
import uml.listener.type.ListenerType;
import uml.manager.ResourceManager;

public abstract class Tool extends JButton {

    private final BufferedImage unselectedImage;
    private final BufferedImage selectedImage;
    private final ImageIcon icon;
    public final ToolMode mode;

    protected Tool(final ToolMode mode, final String imagePathName) {
        // member setting
        this.mode = mode;
        unselectedImage = ResourceManager.getBufferedImage(imagePathName).orElseThrow();
        selectedImage = ResourceManager.getBufferedImage(imagePathName.replaceAll(".png$", "_selected.png"))
                .orElseThrow();
        icon = new ImageIcon(unselectedImage);
        // layout setting
        setIcon(icon);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLoweredBevelBorder());
        setFocusPainted(false);
        setPreferredSize(new Dimension((unselectedImage.getWidth() + selectedImage.getWidth()) / 2,
                (unselectedImage.getHeight() + selectedImage.getHeight()) / 2));
        // event listener setting
        ListenerFactory.generate(ListenerType.Tool).addToComponent(this);
    }

    public void resizeImage() {
        // getSize for copy dimension purpose
        final Dimension size = getPreferredSize().getSize();
        final Insets insets = getMargin();
        size.width -= insets.left + insets.right;
        size.height -= insets.top + insets.bottom;
        if (size.width > size.height)
            size.width = -1;
        else
            size.height = -1;
        icon.setImage((isSelected() ? selectedImage : unselectedImage).getScaledInstance(size.width, size.height,
                Image.SCALE_SMOOTH));
    }

    @Override
    public void setSelected(final boolean b) {
        if (isSelected() == b)
            return;
        setBackground(b ? Color.DARK_GRAY : Color.WHITE);
        super.setSelected(b);
        resizeImage();
    }

    public abstract void drawObject(final MouseEvent mouseEvent, final CanvasPanel cPanel);
}
