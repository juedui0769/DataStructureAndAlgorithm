package com.wxg.study.ch03.template;

import javax.swing.*;

/**
 * create at 2019年3月29日03:35:40
 */
public class AlgorithmConfig {

    public static final int DEFAULT_CANVAS_WIDTH = 1024;
    public static final int DEFAULT_CANVAS_HEIGHT = 768;

    private String title;

    private int canvasWidth;
    private int canvasHeight;

    private JPanel canvas;

    public AlgorithmConfig title(String title) {
        this.title = title;
        return this;
    }

    public String title() {
        return title;
    }

    public AlgorithmConfig width(int canvasWidth) {
        this.canvasWidth = canvasWidth;
        return this;
    }

    public int width() {
        return canvasWidth;
    }

    public AlgorithmConfig height(int canvasHeight) {
        this.canvasHeight = canvasHeight;
        return this;
    }

    public int height() {
        return canvasHeight;
    }

    public AlgorithmConfig canvas(JPanel canvas) {
        this.canvas = canvas;
        return this;
    }

    public JPanel canvas() {
        return canvas;
    }
}
