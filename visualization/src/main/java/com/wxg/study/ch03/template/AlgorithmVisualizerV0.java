package com.wxg.study.ch03.template;

import javax.swing.*;
import java.awt.*;

/**
 * create at 2019年3月29日03:35:56
 */
public abstract class AlgorithmVisualizerV0 {

    private AlgorithmConfig config;

    private JFrame frame;

    public AlgorithmVisualizerV0(AlgorithmConfig config) {
        this.config = config;

        // 初始化数据
        init();

        // 初始化视图
        EventQueue.invokeLater(() -> {
            // AlgorithmFrame frame = new AlgorithmFrame(config);
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

    private static class DefaultFrame extends JFrame {

        public DefaultFrame(AlgorithmConfig config) {
            super(config.title());

            setContentPane(config.canvas());

            setResizable(false);
            pack();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }
}
