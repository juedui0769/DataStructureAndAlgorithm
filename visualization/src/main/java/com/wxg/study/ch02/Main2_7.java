package com.wxg.study.ch02;

import java.awt.*;

/**
 * 2019年3月26日20:07:56
 * <a href="https://docs.oracle.com/javase/tutorial/uiswing/concurrency/dispatch.html">事件分发线程(The Event Dispatch Thread)</a>
 */
public class Main2_7 {
    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;

        int N = 10;
        Circle2_7[] circles = new Circle2_7[N];
        int R = 50;
        for (int i = 0; i < N; i++) {
            int x = (int)(Math.random()*(sceneWidth - 2*R)) + R;
            int y = (int)(Math.random()*(sceneHeight - 2*R)) + R;
            int vx = (int)(Math.random()*11) - 5;
            int vy = (int)(Math.random()*11) - 5;
            circles[i] = new Circle2_7(x, y, R, vx, vy);
        }


        EventQueue.invokeLater(() -> {
            AlgoFrame2_7 frame = new AlgoFrame2_7("Welcome", sceneWidth, sceneHeight);

            // 不要阻塞事件分发线程 https://docs.oracle.com/javase/tutorial/uiswing/concurrency/dispatch.html
            Thread thread = new Thread(() -> {
                while (true) {
                    // 绘制数据
                    frame.render(circles);
                    AlgoVisHelper2_5.pause(20);

                    // 更新数据
                    for (Circle2_7 circle : circles) {
                        circle.move(0, 0, sceneWidth, sceneHeight);
                    }

                }
            });
            thread.setDaemon(true);
            thread.start();

        });
    }
}
