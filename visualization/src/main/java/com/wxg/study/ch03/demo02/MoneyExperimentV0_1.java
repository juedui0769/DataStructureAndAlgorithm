package com.wxg.study.ch03.demo02;

import com.wxg.study.ch02.template.AlgoVisHelper;
import com.wxg.study.ch03.template.AlgorithmCanvasV0_1;
import com.wxg.study.ch03.template.AlgorithmConfig;
import com.wxg.study.ch03.template.AlgorithmVisualizerV0_1;

import java.awt.*;

/**
 * create at 2019年03月29日16:24:19，利用了以下三个类：<p>
 * {@link AlgorithmVisualizerV0_1}, {@link AlgorithmCanvasV0_1}, {@link AlgorithmConfig}
 * </p> 必须遵循一定的书写规则，否则不能正常启动。
 */
public class MoneyExperimentV0_1 extends AlgorithmVisualizerV0_1 {

    private static final int DELAY = 10;

    private static int[] money;

    @Override
    protected void init() {
        money = new int[100];
        for (int i = 0; i < money.length; i++) {
            money[i] = 100;
        }
    }

    @Override
    protected void doRun() {
        while (true) {

            doRepaint();

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

    public static void main(String[] args) {
        AlgorithmConfig conf = new AlgorithmConfig();
        conf.title("Welcome")
                .width(1000)
                .height(400)
                .canvas(new DefaultCanvas().confSize(conf.width(), conf.height()));

        new MoneyExperimentV0_1().setConfig(conf).start();
    }

    private static class DefaultCanvas extends AlgorithmCanvasV0_1 {
        @Override
        protected void doPaint(Graphics2D g) {
            AlgoVisHelper.setColor(g, AlgoVisHelper.Blue);
            int w = canvasWidth / money.length;
            for (int i = 0; i < money.length; i++) {
                AlgoVisHelper.fillRectangle(g,
                        i * w + 1, canvasHeight - money[i], w - 1, money[i]);
            }
        }
    }
}
