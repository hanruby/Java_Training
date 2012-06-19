package ch06.ex06_05;

import java.awt.Color;

/**
 * 信号機の色
 * @author ato
 * ex06_05 Colorオブジェクトを返すために、定数固有のメソッドを使用することは推奨しない。
 * 理由：
 *  - 定数固有の振る舞いとするべきような振る舞いがないため。
 */
public enum TrafficLightColor {
    GREEN {
        @Override
        Color getColor() {
            return Color.GREEN;
        }
    },
    YELLOW {
        @Override
        Color getColor() {
            return Color.YELLOW;
        }
    },
    RED {
        @Override
        Color getColor() {
            return Color.RED;
        }
    };
    
    abstract Color getColor();
}

