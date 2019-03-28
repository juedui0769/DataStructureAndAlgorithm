package com.wxg.study.ch03.template;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * 2019年3月29日03:11:34
 */
public class AlgorithmConfigTest {

    private static int _width = 1000;
    private static int _heith = 500;

    @Test
    public void test01() {
        AlgorithmConfig conf = new AlgorithmConfig();
        conf.title("Welcome")
                .width(_width)
                .height(_heith)
                .canvas(new DefaultCanvas(conf));
        conf = null;
    }

    private static class DefaultCanvas extends AlgorithmCanvas {
        public DefaultCanvas(AlgorithmConfig config) {
            super(config);
            System.out.println(config.width() + ", " + config.height());
            assertEquals(_width, config.width());
            assertEquals(_heith, config.height());
        }
        @Override
        protected void doPaint(Graphics2D g) {
        }
    }
}