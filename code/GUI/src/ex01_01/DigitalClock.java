package ex01_01;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * デジタル時計
 * @author ato
 *
 */
public class DigitalClock extends Frame implements Runnable{

    private ClockWindowListener windowHandler;
    private Calendar cal;
    private DigitalClockSettings settings;
    private Font font;
    
    public DigitalClock() {
        windowHandler = new ClockWindowListener();
        settings = new DigitalClockSettings();
        font =  new Font("Consolas",Font.CENTER_BASELINE,30);
        
        setTitle("Digital Clock");
        setSize(500,120);
        addWindowListener(windowHandler);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        cal = new GregorianCalendar(); // JPL : P.611
        g.setFont(font);
        g.drawString(settings.dateFormat(cal), 10, 50);
    }

    public static void main (String args[]) {
        DigitalClock clock = new DigitalClock();
        new Thread(clock).start();
    }

    // Runnable : JPL P.297 
    @Override
    public void run() {
        try {
            for(;;) {
                repaint();
                Thread.sleep(1000); // wait for 1 second
            }
        } catch (InterruptedException e){
            return;
        }
    }
}

/**
 * Windowがクローズされた場合
 * @author ato
 *
 */
class ClockWindowListener extends WindowAdapter {
    public void windowClosing (WindowEvent event) {
        System.exit (0);
    }
}

