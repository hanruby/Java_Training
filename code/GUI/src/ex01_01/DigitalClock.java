package ex01_01;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

/**
 * 時計用のフレーム
 * @author ato
 *
 */
public class DigitalClock extends Frame {

    private Closer handler;
    private Date date;
    private DigitalClockSettings settings;
    private Font font;
    
    public DigitalClock() {
        handler = new Closer();
        settings = new DigitalClockSettings();
        font =  new Font("Consolas",Font.CENTER_BASELINE,30);
        
        setTitle("Digital Clock");
        setSize(500,120);
        addWindowListener(handler);
        setVisible(true);
    }
    

    public void paint(Graphics g) {
        date = new Date();
        g.setFont(font);
        g.drawString(settings.dateFormat(date), 10, 50);
    }

    public static void main (String args[]) {
        new DigitalClock();
    }
}

/**
 * Windowがクローズされた場合
 * @author ato
 *
 */
class Closer extends WindowAdapter {
    public void windowClosing (WindowEvent event) {
        System.exit (0);
    }
}

