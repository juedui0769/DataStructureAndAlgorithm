package com.wxg.study.ch02;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * 2019年3月26日18:17:16 <p></p>
 * 抗锯齿参考: <a href="https://docs.oracle.com/javase/tutorial/2d/advanced/quality.html">oracle 2d advanced</a>
 */
public class AlgoFrame2_2 extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame2_2(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;

//        setSize(canvasWidth, canvasHeight);
        AlgoCanvas2_3 canvas = new AlgoCanvas2_3();
        // canvas.setSize(new Dimension(canvasWidth, canvasHeight));
        // canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setContentPane(canvas);
        pack();

        System.out.println(canvas.getPreferredSize());

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public AlgoFrame2_2(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    /**
     * 双缓存 : {@link JPanel} 默认就是开启双缓存的，
     * 这里特意的定义在这里，只是为了强调！
     */
    private boolean isDoubleBuffered = true;

    private class AlgoCanvas2_3 extends JPanel {

        public AlgoCanvas2_3() {
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

//            int strokeWidth = 5;
//            g2d.setStroke(new BasicStroke(strokeWidth));
            AlgoVisHelper2_5.setStrokeWidth(g2d, 5);

            AlgoVisHelper2_5.setColor(g2d, Color.BLUE);
            AlgoVisHelper2_5.fillCircle(g2d, canvasWidth/2, canvasHeight/2, 200);

            // --- 先填充，再绘制外框 ---

            AlgoVisHelper2_5.setColor(g2d, Color.RED);
//            Ellipse2D circle = new Ellipse2D.Double(50, 50, 300, 300);
//            g2d.draw(circle);
            AlgoVisHelper2_5.strokeCircle(g2d, canvasWidth/2, canvasHeight/2, 200);

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
