package uml.graphic.component.umlobject.line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.util.TransformUtil;

public class AssociationLine extends Line {

    private final Point arrowCenterPoint = new Point();
    private final Point offsetPerUnit = new Point();
    private final double rad = Math.toRadians(30);
    private final int bodyLength = 15;

    public AssociationLine(final Diagram srcDiagram, final DiagramPortPosition srcPortPos) {
        super(srcDiagram, srcPortPos);
    }

    @Override
    protected void render(final Graphics g, final Point startPoint, final Point endPoint) {
        final double arrowBodyDistance = startPoint.distance(endPoint) / bodyLength;
        // fixed to unit offset measurement
        offsetPerUnit.setLocation((int) Math.round((endPoint.x - startPoint.x) / arrowBodyDistance),
                (int) Math.round((endPoint.y - startPoint.y) / arrowBodyDistance));
        arrowCenterPoint.setLocation(endPoint.x - offsetPerUnit.x, endPoint.y - offsetPerUnit.y);
        final Point arrowLeftPoint = TransformUtil.rotate(endPoint, arrowCenterPoint, rad);
        final Point arrowRightPoint = TransformUtil.rotate(endPoint, arrowCenterPoint, -rad);
        g.setColor(Color.BLACK);
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        g.drawLine(arrowLeftPoint.x, arrowLeftPoint.y, endPoint.x, endPoint.y);
        g.drawLine(arrowRightPoint.x, arrowRightPoint.y, endPoint.x, endPoint.y);
    }
}
