package ex01_01;

import java.awt.Font;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Config {
    private Format format;

    private Font font;
    
    private int width;
    private int height;
    
    public Config() {
        format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        font =  new Font("Consolas",Font.CENTER_BASELINE,30);
        width = 500;
        height = 150;
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
    
}
