package uml.graphic.component.umlobject.line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import uml.graphic.component.umlobject.diagram.Diagram;
import uml.graphic.component.umlobject.diagram.port.position.DiagramPortPosition;
import uml.util.TransformUtil;

public class GeneralizationLine extends Line {

    private final Polygon arrow = new Polygon();
    private final Point arrowCenterPoint = new Point();
    private final Point offsetPerUnit = new Point();
    private final double rad = Math.toRadians(30);
    private final int bodyLength = 15;

    public GeneralizationLine(final Diagram srcDiagram, final DiagramPortPosition srcPortPos) {
        super(srcDiagram, srcPortPos);
        arrow.npoints = 3;
    }

    @Override
    protected void render(Graphics g, Point startPoint, Point endPoint) {
        final double arrowBodyDistance = startPoint.distance(endPoint) / bodyLength;
        // fixed to unit offset measurement
        offsetPerUnit.setLocation((int) Math.round((endPoint.x - startPoint.x) / arrowBodyDistance),
                (int) Math.round((endPoint.y - startPoint.y) / arrowBodyDistance));
        arrowCenterPoint.setLocation(endPoint.x - offsetPerUnit.x, endPoint.y - offsetPerUnit.y);
        final Point arrowLeftPoint = TransformUtil.rotate(endPoint, arrowCenterPoint, rad);
        final Point arrowRightPoint = TransformUtil.rotate(endPoint, arrowCenterPoint, -rad);
        arrow.xpoints[0] = arrowLeftPoint.x;
        arrow.ypoints[0] = arrowLeftPoint.y;
        arrow.xpoints[1] = endPoint.x;
        arrow.ypoints[1] = endPoint.y;
        arrow.xpoints[2] = arrowRightPoint.x;
        arrow.ypoints[2] = arrowRightPoint.y;
        g.setColor(Color.BLACK);
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        g.fillPolygon(arrow);
    }
}
