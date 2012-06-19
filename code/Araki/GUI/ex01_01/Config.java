package ex01_01;

import java.awt.Color;
import java.awt.Font;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Config {
    private Format format;

    private Font font;
    
    private int width;
    private int height;

    private Color backgroundColor;
    private Color fontColor;
    
    public Config() {
        format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        font =  new Font("Consolas",Font.CENTER_BASELINE,30);
        width = 350;
        height = 55;
        backgroundColor = Color.BLACK;
        fontColor = Color.WHITE;
    }
    
    public String dateFormat(Calendar cal) {
        return format.format(cal.getTime());
    }
    
    public Font getFont() {
        return font;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
    
    public Color getFontColor() {
        return fontColor;
    }
    
}
