package ch06.ex06_05;

import java.awt.Color;

/**
 * 信号機の色
 * @author ato
 *
 */
public enum TrafficLightColor {
    GREEN(Color.GREEN),
    YELLOW(Color.YELLOW),
    RED(Color.RED);
    
    Color color;
    TrafficLightColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
    
    public String toString() {
        return color.toString();
    }
}
