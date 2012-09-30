package ex02_01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DigitalClock extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1362097885644824584L;
    private static final String TITLE = "@atotto's Digital Clock";
    private static final int DEFAULT_WIDTH = 320;
    private static final int DEFAULT_HEIGHT = 240;

    private Config config;
    private JFrame clockFrame;

    public static void main(String[] args) {
        new DigitalClock();
    }

    public DigitalClock() {
        config = new Config();
        
        clockFrame = new JFrame(TITLE);
        clockFrame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        // クローズボタンで終了する
        clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clockFrame.setTitle(TITLE);
        clockFrame.getContentPane().add(this);
        clockFrame.setVisible(true);
        time.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gui = (Graphics2D) g;
        
        // 時計文字描画
        gui.setPaint(Color.BLACK);
        gui.drawString(config.clock(new GregorianCalendar(TimeZone.getTimeZone("Japan"))), 10, 50);
    }
    
    private Timer time = new Timer(5, (ActionListener) this);
    int x = 0, y = 0;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
