package uml.util;

import java.awt.Point;

public class TransformUtil {

    private TransformUtil() {
    }

    public static Point rotate(final Point anchor, final Point target, final double radian) {
        final int offsetX = target.x - anchor.x;
        final int offsetY = target.y - anchor.y;
        return new Point(anchor.x + (int) Math.round(offsetX * Math.cos(radian) - offsetY * Math.sin(radian)),
                anchor.y + (int) Math.round(offsetX * Math.sin(radian) + offsetY * Math.cos(radian)));
    }
}
