package uml.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

public class TransformUtilTest {
    @Test
    public void test_rotate_no_throws_with_manyBoundaryPoints_returns_exactlyRotated() {
        assertEquals(new Point(), TransformUtil.rotate(new Point(), new Point(), Math.toRadians(40)));
        assertEquals(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                TransformUtil.rotate(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                        new Point(Integer.MAX_VALUE, Integer.MAX_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE - 1),
                TransformUtil.rotate(new Point(Integer.MIN_VALUE, Integer.MAX_VALUE),
                        new Point(Integer.MAX_VALUE, Integer.MAX_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MIN_VALUE, Integer.MAX_VALUE),
                TransformUtil.rotate(new Point(Integer.MAX_VALUE, Integer.MIN_VALUE),
                        new Point(Integer.MAX_VALUE, Integer.MAX_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MIN_VALUE, Integer.MAX_VALUE),
                TransformUtil.rotate(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                        new Point(Integer.MAX_VALUE, Integer.MAX_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                TransformUtil.rotate(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                        new Point(Integer.MIN_VALUE, Integer.MAX_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MIN_VALUE, Integer.MAX_VALUE),
                TransformUtil.rotate(new Point(Integer.MIN_VALUE, Integer.MAX_VALUE),
                        new Point(Integer.MIN_VALUE, Integer.MAX_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                TransformUtil.rotate(new Point(Integer.MAX_VALUE, Integer.MIN_VALUE),
                        new Point(Integer.MIN_VALUE, Integer.MAX_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MIN_VALUE + 1, Integer.MAX_VALUE),
                TransformUtil.rotate(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                        new Point(Integer.MIN_VALUE, Integer.MAX_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MAX_VALUE - 1, Integer.MIN_VALUE),
                TransformUtil.rotate(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                        new Point(Integer.MAX_VALUE, Integer.MIN_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                TransformUtil.rotate(new Point(Integer.MIN_VALUE, Integer.MAX_VALUE),
                        new Point(Integer.MAX_VALUE, Integer.MIN_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MAX_VALUE, Integer.MIN_VALUE),
                TransformUtil.rotate(new Point(Integer.MAX_VALUE, Integer.MIN_VALUE),
                        new Point(Integer.MAX_VALUE, Integer.MIN_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                TransformUtil.rotate(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                        new Point(Integer.MAX_VALUE, Integer.MIN_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MAX_VALUE, Integer.MIN_VALUE),
                TransformUtil.rotate(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE),
                        new Point(Integer.MIN_VALUE, Integer.MIN_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MAX_VALUE, Integer.MIN_VALUE),
                TransformUtil.rotate(new Point(Integer.MIN_VALUE, Integer.MAX_VALUE),
                        new Point(Integer.MIN_VALUE, Integer.MIN_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE + 1),
                TransformUtil.rotate(new Point(Integer.MAX_VALUE, Integer.MIN_VALUE),
                        new Point(Integer.MIN_VALUE, Integer.MIN_VALUE), Math.toRadians(40)));
        assertEquals(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                TransformUtil.rotate(new Point(Integer.MIN_VALUE, Integer.MIN_VALUE),
                        new Point(Integer.MIN_VALUE, Integer.MIN_VALUE), Math.toRadians(40)));
    }
}
