package ex01_04;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
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
    
    public Config() {
        // Load user preferences
        prefs = Preferences.userNodeForPackage(this.getClass());
        
        // Set preferenses
        clockFormat = new SimpleDateFormat(prefs.get("clockFormat", "yyyy/MM/dd HH:mm:ss"));
        simpleClockFormat = new SimpleDateFormat(prefs.get("simpleClockFormat", "HH:mm:ss"));
        fontsize = prefs.getInt("fontsize", 20);
        fontname =  prefs.get("fontname", "Consolas");
        backgroundColor = new Color(prefs.getInt("backgroundColor", Color.GRAY.getRGB()));
        fontColor = new Color(prefs.getInt("fontColor", Color.BLACK.getRGB()));

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
        prefs.putInt("fontsize", fontsize);
        prefs.put("fontname", fontname);
        prefs.putInt("backgroundColor", backgroundColor.getRGB());
        prefs.putInt("fontColor", fontColor.getRGB());
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
}
