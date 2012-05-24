package ex01_03;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * デジタル時計
 * @author ato
 *
 */
public class DigitalClock extends Window implements Runnable{

    private static final long serialVersionUID = 248840136722015507L;

    private Config config;
    
    private Image clockImage;
    private Graphics canvas;
    private DigitalClock clock;

    private PopupMenu popupmenu;
    
    public DigitalClock(Frame owner) {
        super(owner);
        
        addNotify();
        pack();
        
        config = new Config();
        this.clock = this;

        setConfig(config);
        createMenuBar();
        createPopupMenu();
        
        addWindowListener(new ClockWindowListener());
        addMouseListener(new ClockMouseListener());

        setVisible(true);
    }
    
    public void setConfig(Config conf) {
        this.config = conf;
/* フォントの指定
フォントサイズの指定
文字色の指定
時計の背景色の指定 
*/
        Insets insets = this.getInsets();
        Rectangle2D clockSize = getClockSize();
        // 描画に必要なサイズ + Insets + 描画のmargin
        setSize((int)clockSize.getWidth() + (insets.left + insets.right) + (config.getMargin().left + config.getMargin().right),
                (int)clockSize.getHeight() + (insets.top + insets.bottom) + (config.getMargin().top + config.getMargin().bottom));
        setFont(config.getFont());
        setBackground(config.getBackgroundColor());
        repaint();
        
    }
    
    private Rectangle2D getClockSize() {
        return new TextLayout("0000/00/00 00:00:00", config.getFont(), ((Graphics2D)clock.getGraphics()).getFontRenderContext()).getBounds();
    }
    
    @Override
    public Insets getInsets() {
        // TODO Auto-generated method stub
        return super.getInsets();
        //return new Insets(10,10,10,10);
    }
    
    public Config getConfig() {
        return this.config;
    }
    
    @Override
    public void pack() {
        // TODO Auto-generated method stub
        super.pack();
    }
    
    @Override
    public void paint(Graphics g) {
        Calendar cal = new GregorianCalendar();
        clockImage = createImage(this.getWidth(), this.getHeight());
        canvas = clockImage.getGraphics();
        canvas.setColor(config.getFontColor());
        // 時計文字列の表示（Insets + margin）
        canvas.drawString(config.clock(cal), this.getInsets().left + config.getMargin().left, 
                                             this.getInsets().top + config.getMargin().top + (int)this.getClockSize().getHeight());
        g.drawImage(clockImage, 0, 0, this);

        setIconImage(clockImage); // 時計の画像をアイコンとして表示する
    }

    public static void main (String args[]) {
        Frame f = new Frame();
        DigitalClock clock = new DigitalClock(f);
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

		//setMenuBar(menu);
    }

    /** 
     * ポップアップメニューを作成する
     */
    private void createPopupMenu() {
        popupmenu = new PropertiesPopupMenu(clock);

		add(popupmenu);

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
     * マウスイベント
     * @author ato
     *
     */
    class ClockMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {

            // 右クリックでポップアップメニューを開く
            if ( e.getButton() == MouseEvent.BUTTON3) {
                popupmenu.show(e.getComponent(), e.getX(), e.getY());
            }
            super.mouseClicked(e);
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
