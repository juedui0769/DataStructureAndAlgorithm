package com.wxg.study.ch02;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * 2019年3月26日19:04:10<p></p>
 * <a href="https://github.com/liuyubobobo/Play-with-Algorithm-Visualization/blob/master/02-Java-Swing-Basics/05-Drawing-Refactor/src/AlgoVisHelper.java">bobo老师 github AlgoVisHelper.java</a>
 */
public class AlgoVisHelper2_5 {
    private AlgoVisHelper2_5() {}

    public static void setStrokeWidth(Graphics2D g2d, int w) {
        int strokeWidth = w;
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public static void setColor(Graphics2D g2d, Color color) {
        g2d.setColor(color);
    }

    /**
     * (x, y) - 圆心 ; r - 半径
     * @param g2d
     * @param x
     * @param y
     * @param r
     */
    public static void strokeCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }

    // (x, y) - 圆心 ; r - 半径
    public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }
}
