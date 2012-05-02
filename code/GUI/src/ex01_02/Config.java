package ex01_02;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Config implements Cloneable {
    private Format format;
    private Insets margin;

    private Font font;
    
    private int width;
    private int height;

    private Color backgroundColor;
    private Color fontColor;
    
    public Config() {
        format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        font =  new Font("Consolas",Font.PLAIN,30);
        width = 500;
        height = 150;
        backgroundColor = Color.BLACK;
        fontColor = Color.WHITE;
        margin = new Insets(10, 10, 10, 10);
    }

    public Config(Font font, Color bgcolor, Color fontColor) {
        this();
        this.font =  font;
        this.backgroundColor = bgcolor;
        this.fontColor = fontColor;
    }

    public Config(Config conf) {
        this.format = conf.format;
        this.font =  conf.font;
        this.backgroundColor = conf.backgroundColor;
        this.fontColor = conf.fontColor;
        this.width = conf.width;
        this.height = conf.height;
        this.margin = conf.margin;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Config newConf = new Config(this);
        return newConf;
    }
    
    public String dateFormat(Calendar cal) {
        return format.format(cal.getTime());
    }
    
    public Font getFont() {
        return font;
    }
    
    public void setFont(Font font) {
        this.font = font;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
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
