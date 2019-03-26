package com.wxg.study.ch02;

import javax.swing.*;
import java.awt.*;

/**
 * 2019年3月26日18:09:02 <p></p>
 * <a href="https://github.com/liuyubobobo/Play-with-Algorithm-Visualization/tree/master/02-Java-Swing-Basics">02-Java-Swing-Basics</a>
 */
public class Main2_1 {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Welcome");
            frame.setSize(500, 500);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

    }
}
