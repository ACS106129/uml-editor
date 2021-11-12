package uml.graphic.component.umlobject.line;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Optional;

import uml.graphic.component.umlobject.UMLObject;
import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;

public abstract class Line extends UMLObject {

    private final Diagram srcDiagram;
    private final DiagramPortPosition srcPortPos;
    private Optional<Diagram> destDiagram = Optional.empty();
    private Optional<DiagramPortPosition> destPortPos = Optional.empty();
    private final Point bufferedPoint = new Point();
    private boolean isAttached = false;

    protected Line(final Diagram srcDiagram, final DiagramPortPosition srcPortPos) {
        // member
        this.srcDiagram = srcDiagram;
        this.srcPortPos = srcPortPos;
        // update
        srcDiagram.setSelect(true);
        bufferedPoint.setLocation(getStartPoint());
        // layout
        setLayout(null);
        setOpaque(false);
        setBounds(getBounds());
    }

    public void updateBufferedPoint(final Point p) {
        bufferedPoint.setLocation(p);
    }

    /**
     * Attach this line to both src and dest diagrams
     */
    public void attachDiagram() {
        srcDiagram.attachLine(this, srcPortPos);
        destDiagram.orElseThrow().attachLine(this, (destPortPos = getDestPortPos()).orElseThrow());
        isAttached = true;
    }

    /**
     * Detach this line from both src and dest diagrams, followed with a invoker to
     * prevent self-call again
     * 
     * @param invoker the caller diagram
     */
    public void invokeDetach(final Diagram invoker) {
        if (!isAttached)
            return;
        isAttached = false;
        if (invoker != srcDiagram && invoker != destDiagram.orElseThrow())
            throw new IllegalArgumentException("Invoker mismatched!");
        ((invoker == srcDiagram) ? destDiagram.orElseThrow() : srcDiagram).detachLine(this);
        getParent().remove(this);
    }

    public boolean isHoverOnDestPort() {
        return getDestPortPos().isPresent();
    }

    /**
     * @return {@code true} if replaced with new dest diagram, else {@code false}
     */
    public boolean replaceDestDiagram(final Diagram destDiagram) {
        // prevent repeated or source diagram
        if (this.destDiagram.orElse(null) == destDiagram || srcDiagram == destDiagram)
            return false;
        // deselect previous diagram
        this.destDiagram.ifPresent(d -> d.setSelect(false));
        // assign new diagram
        this.destDiagram = Optional.of(destDiagram);
        destDiagram.setSelect(true);
        return true;
    }

    @Override
    public Rectangle getBounds() {
        final Rectangle bounds = new Rectangle(getStartPoint());
        bounds.add(getEndPoint());
        bounds.grow(30, 30);
        return bounds;
    }

    protected Optional<DiagramPortPosition> getDestPortPos() {
        return destPortPos.isPresent() ? destPortPos
                : destDiagram.flatMap(d -> d.getPortPositionByContains(bufferedPoint));
    }

    @Override
    protected final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Point globalOffset = getLocation();
        final Point startPoint = getStartPoint();
        final Point endPoint = getEndPoint();
        render(g, new Point(startPoint.x - globalOffset.x, startPoint.y - globalOffset.y),
                new Point(endPoint.x - globalOffset.x, endPoint.y - globalOffset.y));
        setBounds(getBounds());
    }

    protected abstract void render(final Graphics g, final Point startPoint, final Point endPoint);

    private Point getStartPoint() {
        return getAttachedPoint(Optional.of(srcDiagram), Optional.of(srcPortPos)).orElseThrow();
    }

    private Point getEndPoint() {
        return getAttachedPoint(destDiagram, getDestPortPos()).orElse(bufferedPoint);
    }

    private Optional<Point> getAttachedPoint(final Optional<Diagram> diagram, final Optional<DiagramPortPosition> pos) {
        return pos.flatMap(p -> diagram.flatMap(d -> d.getPortBounds(pos).map(b -> {
            switch (p) {
            case Left:
                return new Point(b.x + b.width, b.y + b.height / 2);
            case Top:
                return new Point(b.x + b.width / 2, b.y + b.height);
            case Right:
                return new Point(b.x, b.y + b.height / 2);
            case Bottom:
                return new Point(b.x + b.width / 2, b.y);
            default:
                return null;
            }
        })));
    }

}
