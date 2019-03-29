package com.wxg.study.ch03.template;

import javax.swing.*;
import java.awt.*;

/**
 * create at 2019年3月29日03:35:23
 */
@Deprecated
public abstract class AlgorithmCanvasV0 extends JPanel {

    private AlgorithmConfig config;

    public AlgorithmCanvasV0(AlgorithmConfig config) {
        // 双缓存
        super(true);
        this.config = config;
    }

    /**
     * Add at 2019年03月29日14:10:30，
     * 提供无参构造方法以方便子类继承。
     * <span style="text-decoration:line-through;">但是，子类必须重写 {@link #setPreferredSize(Dimension)} 方法。</span>
     * 这个类不应该持有一个 {@link AlgorithmConfig} 对象的, 它只需要width和height两个整型即可，
     * 参考 {@link AlgorithmCanvasV0_1}
     */
    public AlgorithmCanvasV0() {
        super(true);
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

    public void setConfig(AlgorithmConfig config) {
        this.config = config;
    }
}
