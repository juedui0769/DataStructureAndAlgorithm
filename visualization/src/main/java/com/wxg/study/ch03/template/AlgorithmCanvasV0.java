package com.wxg.study.ch03.template;

import javax.swing.*;
import java.awt.*;

/**
 * create at 2019年3月29日03:35:23
 */
public abstract class AlgorithmCanvasV0 extends JPanel {

    private AlgorithmConfig config;

    public AlgorithmCanvasV0(AlgorithmConfig config) {
        // 双缓存
        super(true);
        this.config = config;
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

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(config.width(), config.height());
    }

    protected abstract void doPaint(Graphics2D g);
}
