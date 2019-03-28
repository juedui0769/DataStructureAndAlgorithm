package com.wxg.study.ch03.demo02;

import com.wxg.study.ch02.template.AlgoVisHelper;
import com.wxg.study.ch03.template.AlgorithmCanvas;
import com.wxg.study.ch03.template.AlgorithmConfig;
import com.wxg.study.ch03.template.AlgorithmVisualizer;

import java.awt.*;

/**
 * create at 2019年3月29日03:34:46
 */
public class MoneyExperimentV0 extends AlgorithmVisualizer {

    /**
     * 这个参数应该放到配置类中的
     */
    private static final int DELAY = 10;

    // TODO: 创建自己的数据
    private static int[] money;

    public MoneyExperimentV0(AlgorithmConfig config) {
        super(config);
    }

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
            //frame.render(money);
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
                .height(500)
                .canvas(new DefaultCanvas(conf));

        new MoneyExperimentV0(conf);
    }

    private static class DefaultCanvas extends AlgorithmCanvas {

        private AlgorithmConfig config;

        public DefaultCanvas(AlgorithmConfig config) {
            super(config);
            this.config = config;
        }

        @Override
        protected void doPaint(Graphics2D g) {
            AlgoVisHelper.setColor(g, AlgoVisHelper.Blue);
            int w = config.width() / money.length;
            for (int i = 0; i < money.length; i++) {
                AlgoVisHelper.fillRectangle(g,
                        i * w + 1, config.height() - money[i], w - 1, money[i]);
            }
        }
    }
}
