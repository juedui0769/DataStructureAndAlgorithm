package com.wxg.study.ch03.template;

import javax.swing.*;
import java.awt.*;

/**
 * create at 2019年03月29日16:25:26
 */
public abstract class AlgorithmCanvasV0_1 extends JPanel {

    protected int canvasWidth;
    protected int canvasHeight;

    public AlgorithmCanvasV0_1() {}

    public AlgorithmCanvasV0_1 confSize(int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

        // 抗锯齿
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.addRenderingHints(hints);

        // 具体绘制
        // TODO： 绘制自己的数据data
        doPaint(g2d);
    }

    protected abstract void doPaint(Graphics2D g);
}
