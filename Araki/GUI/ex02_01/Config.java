package ex02_01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.prefs.Preferences;

public class Config implements Cloneable {
    private Preferences prefs;
    
    private DateFormat clockFormat;
    private DateFormat simpleClockFormat;
    private Insets margin;

    private String fontname;
    private int fontsize;

    private Color backgroundColor;
    private Color fontColor;
    private Point clockPos;

    public Config() {
        // Load user preferences
        prefs = Preferences.userNodeForPackage(this.getClass());
        
        // Set preferenses
        clockFormat = new SimpleDateFormat(prefs.get("a2.clockFormat", "yyyy/MM/dd HH:mm:ss"));
        simpleClockFormat = new SimpleDateFormat(prefs.get("a2.simpleClockFormat", "HH:mm:ss"));
        fontsize = prefs.getInt("a2.fontsize", 20);
        fontname =  prefs.get("a2.fontname", "Consolas");
        backgroundColor = new Color(prefs.getInt("a2.backgroundColor", Color.GRAY.getRGB()));
        fontColor = new Color(prefs.getInt("a2.fontColor", Color.BLACK.getRGB()));

        clockPos = new Point(prefs.getInt("a2.clockPos_x", 0), prefs.getInt("a2.clockPos_y", 0));
        margin = new Insets(10, 10, 10, 10);
    }

    public Config(Config conf) {
        this.clockFormat = conf.clockFormat;
        this.simpleClockFormat = conf.simpleClockFormat;
        this.fontname =  conf.fontname;
        this.fontsize = conf.fontsize;
        this.backgroundColor = conf.backgroundColor;
        this.fontColor = conf.fontColor;
        this.margin = conf.margin;
        this.clockPos = conf.clockPos;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Config newConf = new Config(this);
        return newConf;
    }
    
    public void savePref() {
        // Load user preferences
        prefs = Preferences.userNodeForPackage(this.getClass());

        // Save preferences
        //clockFormat
        //simpleClockFormat
        prefs.putInt("a2.fontsize", fontsize);
        prefs.put("a2.fontname", fontname);
        prefs.putInt("a2.backgroundColor", backgroundColor.getRGB());
        prefs.putInt("a2.fontColor", fontColor.getRGB());
        prefs.putInt("a2.clockPos_x", clockPos.x);
        prefs.putInt("a2.clockPos_y", clockPos.y);
    }
    
    public String clock(Calendar cal) {
        clockFormat.setTimeZone(cal.getTimeZone());
        return clockFormat.format(cal.getTime());
    }
    
    public String simpleClock(Calendar cal) {
        return simpleClockFormat.format(cal.getTime());
    }
    
    public Font getFont() {
        return new Font(fontname,Font.PLAIN, fontsize);
    }
    
    public void setFont(Font font) {
        this.fontname = font.getName();
        this.fontsize = font.getSize();
    }
    
    public String getFontName() {
        return fontname;
    }
    
    public void setFontName(String fontname) {
        this.fontname = fontname;
    }
    
    public int getFontSize() {
        return fontsize;
    }
    
    public void setFontSize(int fontsize) {
        this.fontsize = fontsize;
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
    
    public Point getPosition() {
        return clockPos;
    }
    
    public void setPosition(Point pos) {
        this.clockPos = pos;
    }
}
