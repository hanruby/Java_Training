package ex01_01;

import java.awt.*;
import java.awt.event.*;

/**
 * 時計用のフレーム
 * @author ato
 *
 */
public class DigitalClock extends Frame {

    private Closer Handler;
    
    public DigitalClock() {
        Handler = new Closer();
        setTitle("Digital Clock");
        setSize(300,120);
        addWindowListener(Handler);
        setVisible(true);
    }

    Font f=new Font("Consolas",Font.CENTER_BASELINE,30);

    public void paint(Graphics g) {
        g.setFont(f);
        g.drawString("Hello Java !!", 10, 50);
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

