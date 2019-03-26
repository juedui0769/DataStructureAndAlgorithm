package com.wxg.study.ch02;

import javax.swing.*;
import java.awt.*;

public class AlgoFrame2_7 extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame2_7(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;

        AlgoCanvas2_7 canvas = new AlgoCanvas2_7();
        setContentPane(canvas);
        pack();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public AlgoFrame2_7(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private Circle2_7[] circles;

    public void render(Circle2_7[] circles) {
        this.circles = circles;
        repaint();
    }

    /**
     * 双缓存 : {@link JPanel} 默认就是开启双缓存的，
     * 这里特意的定义在这里，只是为了强调！
     */
    private boolean isDoubleBuffered = true;

    private class AlgoCanvas2_7 extends JPanel {

        public AlgoCanvas2_7() {
            super(isDoubleBuffered);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // g.drawOval(50, 50, 300, 300);  // 绘制圆

            Graphics2D g2d = (Graphics2D) g;

            // https://docs.oracle.com/javase/tutorial/2d/advanced/quality.html
            // 抗锯齿
            RenderingHints hints
                    = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            AlgoVisHelper2_5.setStrokeWidth(g2d, 1);
            AlgoVisHelper2_5.setColor(g2d, Color.RED);
            for (Circle2_7 circle : circles) {
                if (circle.isFilled) {
                    AlgoVisHelper2_5.fillCircle(g2d, circle.x, circle.y, circle.getR());
                } else {
                    AlgoVisHelper2_5.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                }
            }
        }

        /**
         * 视频中，老师先演示了外部设置`setPreferredSize`的方式，
         * 接着使用覆盖父类方法的方式，来设置画布的大小，
         * 以遵循“谁的事儿谁做主的原则”
         * @return
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
