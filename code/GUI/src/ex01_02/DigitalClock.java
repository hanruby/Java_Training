package ex01_02;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;

/**
 * デジタル時計
 * @author ato
 *
 */
public class DigitalClock extends Frame implements Runnable{

    private static final long serialVersionUID = 248840136722015507L;

    private Config config;
    
    private Image clockImage;
    private Graphics canvas;
    
    public DigitalClock() {
        config = new Config();

        setSize(config.getWidth(), config.getHeight());
        setFont(config.getFont());
        setBackground(config.getBackgroundColor());

        addWindowListener(new ClockWindowListener());
        setVisible(true);

        if (SystemTray.isSupported()) {
            showTrayIcon();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        Calendar cal = new GregorianCalendar();
        clockImage = createImage(this.getWidth(), this.getHeight());
        canvas = clockImage.getGraphics();
        canvas.setColor(config.getFontColor());
        canvas.drawString(config.dateFormat(cal), 10, 50);
        g.drawImage(clockImage, 0, 0, this);

        setIconImage(clockImage); // 時計の画像をアイコンとして表示する

        setTitle(config.dateFormat(cal)); // 時刻をタイトルへ表示する
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
    
    /**
     * トレイアイコンを表示する
     */
    private void showTrayIcon() {
        SystemTray tray = SystemTray.getSystemTray();
        Image trayImage;
        try {
            trayImage = ImageIO.read(new File("src/ex01_01/clock.png"));
            try {
                tray.add(new TrayIcon(trayImage,"Digital Clock"));
            } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

/**
 * Windowがクローズされた場合
 * @author ato
 *
 */
class ClockWindowListener extends WindowAdapter {
    @Override
    public void windowClosing (WindowEvent event) {
        System.exit (0);
    }
}

