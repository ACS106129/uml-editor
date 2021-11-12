package uml.graphic.component.umlobject.diagram;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import uml.graphic.component.umlobject.UMLObject;
import uml.graphic.component.umlobject.diagram.content.DiagramContent;
import uml.graphic.component.umlobject.diagram.port.DiagramPort;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.graphic.component.umlobject.line.Line;

public class Diagram extends UMLObject {

    private final DiagramContent content;
    protected final Map<DiagramPortPosition, DiagramPort> portMap = new ConcurrentHashMap<>();

    public Diagram(final int portSize, final Point pos, final DiagramContent content) {
        this(Collections.nCopies(DiagramPortPosition.values().length, portSize), pos, content);
    }

    /**
     * @param portSizes Left, Top, RightD, Bottom respectively
     */
    public Diagram(final List<Integer> portSizes, final Point pos, final DiagramContent content) {
        setLayout(null);
        setOpaque(false);
        setBounds(pos.x - portSizes.get(0), pos.y - portSizes.get(1),
                portSizes.get(0) + portSizes.get(2) + content.getWidth(),
                portSizes.get(1) + portSizes.get(3) + content.getHeight());
        this.content = content;
        this.content.setLocation(new Point(portSizes.get(0), portSizes.get(1)));
        final List<Point> portPositions = Arrays.asList(new Point(0, (content.getHeight() + portSizes.get(1)) / 2),
                new Point((content.getWidth() + portSizes.get(0)) / 2, 0),
                new Point(content.getWidth() + portSizes.get(0), (content.getHeight() + portSizes.get(1)) / 2),
                new Point((content.getWidth() + portSizes.get(0)) / 2, content.getHeight() + portSizes.get(1)));
        for (int i = 0; i < portSizes.size(); ++i) {
            final DiagramPort port = new DiagramPort(portSizes.get(i));
            port.setBounds(portPositions.get(i).x, portPositions.get(i).y, portSizes.get(i), portSizes.get(i));
            portMap.put(DiagramPortPosition.values()[i], port);
        }
        // append components
        add(content);
        portMap.values().forEach(Diagram.this::add);
    }

    public void detachAllLines() {
        getAttachedLines().forEach(Diagram.this::detachLine);
    }

    public void rename(final String name) {
        content.rename(name);
    }

    public void setSelect(final boolean isSelected) {
        portMap.values().forEach(p -> p.setVisible(isSelected));
    }

    public void detachLine(final Line line) {
        line.invokeDetach(this);
        portMap.values().forEach(port -> port.attachedLines.remove(line));
    }

    public void attachLine(final Line line, final DiagramPortPosition portPos) {
        portMap.get(portPos).attachedLines.add(line);
    }

    public boolean isSelected() {
        return portMap.values().stream().anyMatch(p -> p.isVisible());
    }

    public String getText() {
        return content.getText();
    }

    @Override
    public String toString() {
        return "Diagram[" + content + portMap.get(DiagramPortPosition.Left) + ", "
                + portMap.get(DiagramPortPosition.Top) + ", " + portMap.get(DiagramPortPosition.Right) + ", "
                + portMap.get(DiagramPortPosition.Bottom) + "]";
    }

    /**
     * {@inheritDoc}
     * <p>
     * If there is/are {@code GroupDiagram} as parent(s), it will get the global
     * bounds by bottom-up accumulating the relative to parent bounds
     * 
     * @return methods of bounds
     */
    @Override
    public Rectangle getBounds() {
        final Rectangle bounds = super.getBounds();
        return Optional.ofNullable(getParent()).map(parent -> {
            while (parent instanceof GroupDiagram) {
                final Point parentPos = parent.getLocation();
                bounds.setLocation(bounds.x + parentPos.x, bounds.y + parentPos.y);
                parent = parent.getParent();
            }
            return bounds;
        }).orElse(bounds);
    }

    public Optional<DiagramPortPosition> getPortPositionByContains(final Point pos) {
        for (final DiagramPortPosition portPos : portMap.keySet())
            if (getPortBounds(Optional.of(portPos)).orElseThrow().contains(pos))
                return Optional.of(portPos);
        return Optional.empty();
    }

    public Optional<Rectangle> getContentBounds() {
        return getComponentGlobalBounds(content);
    }

    public Optional<Rectangle> getPortBounds(final Optional<DiagramPortPosition> pos) {
        return pos.flatMap(p -> getComponentGlobalBounds(portMap.getOrDefault(p, null)));
    }

    public List<Line> getAttachedLines() {
        return portMap.values().stream().map(port -> port.attachedLines).flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private Optional<Rectangle> getComponentGlobalBounds(final Component comp) {
        if (comp == null)
            return Optional.empty();
        final Rectangle bounds = comp.getBounds();
        return Optional
                .of(new Rectangle(bounds.x + getBounds().x, bounds.y + getBounds().y, bounds.width, bounds.height));
    }
}
