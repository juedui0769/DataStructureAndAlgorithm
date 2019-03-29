package com.wxg.study.ch03.template;

import javax.swing.*;
import java.awt.*;

/**
 * create at 2019年03月29日16:24:39
 */
public abstract class AlgorithmVisualizerV0_1 {

    private AlgorithmConfig config;

    private JFrame frame;

    /**
     * 提供无参构造方法方便子类继承，
     * 必须调用 {@link #setConfig(AlgorithmConfig)} 方法设置 {@link AlgorithmConfig},
     * 调用 {@link #start()} 启动。
     */
    public AlgorithmVisualizerV0_1() {}

    public void start() {
        if (config == null) {
            throw new RuntimeException("config == null, 请调用`setConfig(AlgorithmConfig)`方法设置必要的属性!");
        }

        // 初始化数据
        init();

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new DefaultFrame(config);
            Thread thread = new Thread(() -> {
                doRun();
            });

            // 将AWT事件分发器启动的线程设置为守护线程
            thread.setDaemon(true);
            thread.start();
        });
    }

    /**
     * 初始化数据
     */
    protected abstract void init();

    /**
     * 动画逻辑
     */
    protected abstract void doRun();

    protected void doRepaint() {
        frame.repaint();
    }

    public AlgorithmVisualizerV0_1 setConfig(AlgorithmConfig config) {
        this.config = config;
        return this;
    }

    private static class DefaultFrame extends JFrame {

        public DefaultFrame(AlgorithmConfig config) {
            super(config.title());

            // Add at 2019年03月29日15:22:34，这里获取`config`对象比较方便，在这里设置size更简单。
            JPanel canvas = config.canvas();
            canvas.setPreferredSize(new Dimension(config.width(), config.height()));
            // setContentPane(config.canvas());
            setContentPane(canvas);

            setResizable(false);
            pack();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }
}
