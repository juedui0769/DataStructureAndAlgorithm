package com.wxg.study.ch02;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * 2019年3月26日18:17:16 <p></p>
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

    private class AlgoCanvas2_3 extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // g.drawOval(50, 50, 300, 300);  // 绘制圆

            Graphics2D g2d = (Graphics2D) g;

            int strokeWidth = 10;
            g2d.setStroke(new BasicStroke(strokeWidth));

            g2d.setColor(Color.RED);
            Ellipse2D circle = new Ellipse2D.Double(50.2, 50, 300, 300);
            g2d.draw(circle);

            g2d.setColor(Color.BLACK);
            Ellipse2D circle2 = new Ellipse2D.Double(60, 60, 280, 280);
            g2d.fill(circle2);
        }

        /**
         * 视频中，老师先演示了外部设置`setPreferredSize`的方式，
         * 接着使用覆盖父类方法的方式，来设置画布的大小，
         * 以遵循“谁的事儿谁自己做主的原则”
         * @return
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
