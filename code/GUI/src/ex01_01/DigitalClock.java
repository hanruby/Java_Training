package ex01_01;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;

/**
 * デジタル時計
 * @author ato
 *
 */
public class DigitalClock extends Frame implements Runnable{

    private static final long serialVersionUID = 248840136722015507L;

    private Config config;
    
    public DigitalClock() {
        config = new Config();

        setTitle("Digital Clock");
        setSize(config.getWidth(), config.getHeight());
        setFont(config.getFont());
        setBackground(config.getBackgroundColor());

        addWindowListener(new ClockWindowListener());
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(config.getFontColor());
        g.drawString(config.dateFormat(new GregorianCalendar()), 10, 50);
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

