package ex01_03;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Config implements Cloneable {
    private DateFormat clockFormat;
    private DateFormat simpleClockFormat;
    private Insets margin;

    private Font font;

    private Color backgroundColor;
    private Color fontColor;
    
    public Config() {
        clockFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        simpleClockFormat = new SimpleDateFormat("HH:mm:ss");
        font =  new Font("Consolas",Font.PLAIN,20);
        backgroundColor = Color.GRAY;
        fontColor = Color.BLACK;
        margin = new Insets(10, 10, 10, 10);
    }

    public Config(Font font, Color bgcolor, Color fontColor) {
        this();
        this.font =  font;
        this.backgroundColor = bgcolor;
        this.fontColor = fontColor;
    }

    public Config(Config conf) {
        this.clockFormat = conf.clockFormat;
        this.simpleClockFormat = conf.simpleClockFormat;
        this.font =  conf.font;
        this.backgroundColor = conf.backgroundColor;
        this.fontColor = conf.fontColor;
        this.margin = conf.margin;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Config newConf = new Config(this);
        return newConf;
    }
    
    public String clock(Calendar cal) {
        clockFormat.setTimeZone(cal.getTimeZone());
        return clockFormat.format(cal.getTime());
    }
    
    public String simpleClock(Calendar cal) {
        return simpleClockFormat.format(cal.getTime());
    }
    
    public Font getFont() {
        return font;
    }
    
    public void setFont(Font font) {
        this.font = font;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
    
    public void setBackgroundColor(Color color) {
        backgroundColor = color;
    }
    
    public Color getFontColor() {
        return fontColor;
    }
    
    public void setFontColor(Color color) {
        fontColor = color;
    }
    
    public Insets getMargin() {
        return this.margin;
    }
}
