package com.wxg.study.ch03.demo01;

import com.wxg.study.ch02.template.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 */
public class AlgoVisualizer {

    private static final int DELAY = 10;
    // TODO: 创建自己的数据
    private int[] money;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        // TODO: 初始化数据
        money = new int[100];
        for (int i = 0; i < money.length; i++) {
            money[i] = 100;
        }

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
//            frame.addKeyListener(new AlgoKeyListener());
//            frame.addMouseListener(new AlgoMouseListener());
            Thread thread = new Thread(() -> {
                run();
            });

            // 这里是我添加的，把AWT事件分发器启动的线程设置为守护线程
            thread.setDaemon(true);
            thread.start();
        });
    }

    // 动画逻辑
    private void run(){

        // TODO: 编写自己的动画逻辑
        while (true) {
            frame.render(money);
            AlgoVisHelper.pause(DELAY);

            for (int i = 0; i < money.length; i++) {
                if (money[i] > 0) {
                    int j = (int)(Math.random() * money.length);
                    money[i] -= 1;
                    money[j] += 1;
                }
            }
        }
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
//    private class AlgoKeyListener extends KeyAdapter { }
//    private class AlgoMouseListener extends MouseAdapter { }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
