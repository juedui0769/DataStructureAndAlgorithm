package com.wxg.study.ch02;

import javax.swing.*;

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

        setSize(canvasWidth, canvasHeight);
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
}
