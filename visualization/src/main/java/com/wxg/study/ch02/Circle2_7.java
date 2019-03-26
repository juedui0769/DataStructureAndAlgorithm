package com.wxg.study.ch02;

import java.awt.*;

/**
 * 2019年3月26日19:39:56
 */
public class Circle2_7 {

    public int x, y;
    private int r;
    public int vx, vy;

    /**
     * 是`实心圆`还是`空心圆`
     */
    public boolean isFilled = false;

    public Circle2_7(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR() {
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy) {
        x += vx;
        y += vy;

        checkCollision(minx, miny, maxx, maxy);
    }

    /**
     * 鼠标点击的位置是否在圆内部，
     * `目标点` 到 `圆心` 的距离是否小于半径，
     * (x, y) 到 (a, b) 的距离是： (x-a)² + (y-b)² ，再开平方。
     * @param p
     * @return
     */
    public boolean contain(Point p) {
        return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) <= r * r;
    }

    private void checkCollision(int minx, int miny, int maxx, int maxy) {
        if (x - r <  minx) { x = r;        vx = -vx; }
        if (x + r >= maxx) { x = maxx - r; vx = -vx; }
        if (y - r <  miny) { y = r;        vy = -vy; }
        if (y + r >= maxy) { y = maxy - r; vy = -vy; }
    }
}
