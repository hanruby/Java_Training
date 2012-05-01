package ex01_02;

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

    private static final long serialVersionUID = 248840136722015507L;

    private Config config;
    
    private Image clockImage;
    private Graphics canvas;
    private DigitalClock clock;
    
    public DigitalClock() {
        config = new Config();
        this.clock = this;

        setConfig(config);
        createMenuBar();

        addWindowListener(new ClockWindowListener());
        setVisible(true);
    }
    
    public void setConfig(Config conf) {
        this.config = conf;
/* フォントの指定
フォントサイズの指定
文字色の指定
時計の背景色の指定 
*/
        setSize(config.getWidth(), config.getHeight());
        setFont(config.getFont());
        setBackground(config.getBackgroundColor());
        repaint();
    }
    
    public Config getConfig() {
        return this.config;
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

    /** 
     * メニューバーを作成する
     */
    private void createMenuBar() {
        MenuBar menu = new MenuBar();
		Menu properties = menu.add(new Menu("File"));

		// プロパティ
		properties.add("Properties");
		properties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PropertiesDialog(clock);
            }
        });

		setMenuBar(menu);
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
    @Override
    public void windowClosing (WindowEvent event) {
        System.exit (0);
    }
}

