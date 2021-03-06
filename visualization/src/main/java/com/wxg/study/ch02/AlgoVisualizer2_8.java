package com.wxg.study.ch02;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 2019年3月26日22:44:19
 * MVC(Controller)
 */
public class AlgoVisualizer2_8 {

    private Circle2_7[] circles;
    private AlgoFrame2_7 frame;

    private boolean isAnimated = true;

    public AlgoVisualizer2_8(int sceneWidth, int sceneHeight, int N) {
        circles = new Circle2_7[N];
        int R = 50;
        for (int i = 0; i < N; i++) {
            int x = (int)(Math.random()*(sceneWidth - 2*R)) + R;
            int y = (int)(Math.random()*(sceneHeight - 2*R)) + R;
            int vx = (int)(Math.random()*11) - 5;
            int vy = (int)(Math.random()*11) - 5;
            circles[i] = new Circle2_7(x, y, R, vx, vy);
        }

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame2_7("Welcome", sceneWidth, sceneHeight);

            frame.addKeyListener(new AlgoKeyListener2_9());
//            frame.addMouseListener(new AlgoMouseListener2_10());

            frame.getContentPane().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
//                    System.out.println(e.getPoint());
                    for (Circle2_7 circle : circles) {
                        if (circle.contain(e.getPoint())) {
                            circle.isFilled = !circle.isFilled;
                        }
                    }
                }
            });

            // 不要阻塞事件分发线程 https://docs.oracle.com/javase/tutorial/uiswing/concurrency/dispatch.html
            Thread thread = new Thread(() -> {
                run();
            });
            thread.setDaemon(true);
            thread.start();

        });
    }

    public static void main(String[] args) {
        int sceneWidth = 800;
        int sceneHeight = 800;

        int N = 10;

        new AlgoVisualizer2_8(sceneWidth, sceneHeight, N);
    }

    /**
     * 动画逻辑
     */
    private void run() {
        while (true) {
            // 绘制数据
            frame.render(circles);
            AlgoVisHelper2_5.pause(20);

            // 更新数据
            if (isAnimated) {
                for (Circle2_7 circle : circles) {
                    circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
                }
            }
        }
    }

    /**
     * 键盘事件监听器
     */
    private class AlgoKeyListener2_9 extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent event) {
            if (event.getKeyChar() == ' ') {
                isAnimated = !isAnimated;
            }
        }
    }

    /**
     * 鼠标事件监听器
     * <p>
     * 没有使用，得到的`坐标值`不准确
     * </p>
     */
    private class AlgoMouseListener2_10 extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            System.out.println(frame.getBounds());
            System.out.println("x: " + event.getX());
            System.out.println("y: " + event.getY());
            System.out.println(event.getPoint());
            System.out.println("---");
            event.translatePoint(-(frame.getBounds().width - frame.getCanvasWidth())/2,
                    -(frame.getBounds().height - frame.getCanvasHeight()));
            System.out.println(event.getPoint());
        }
    }
}
