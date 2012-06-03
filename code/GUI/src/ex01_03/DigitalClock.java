package ex01_03;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.imageio.ImageIO;

/**
 * デジタル時計
 * @author ato
 *
 */
public class DigitalClock extends Window implements Runnable{

    private static final long serialVersionUID = 248840136722015507L;

    private Config config;
    
    private BufferedImage clockImage;
    private Graphics2D bufGraphics;
    private DigitalClock clock;

    private PopupMenu popupmenu;

    private Image backgroundImage = null;
    private Image clockiconImage = null;
    
    public DigitalClock(Frame owner) {
        super(owner);
        
        addNotify();
        pack();

        loadImage();
        setSize(backgroundImage.getWidth(this),backgroundImage.getHeight(this));
        
        setBackground(new Color(0,0,0,0));

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

        repaint();
    }
        
    private void loadImage() {
        try {
            backgroundImage = ImageIO.read(new File("image/1000px-BlankMap-World-162E.svg.png"));
            clockiconImage = ImageIO.read(new File("image/clock.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
        clockImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);;
        bufGraphics = (Graphics2D) clockImage.getGraphics();
        
        bufGraphics.setBackground(new Color(0,0,0,0));
        bufGraphics.setFont(config.getFont());

        // 背景画像の表示
        //bufGraphics.drawImage(backgroundImage.getScaledInstance(100, 300, Image.SCALE_DEFAULT), 0, 0, new Color(0,0,0,0), this);
        bufGraphics.drawImage(backgroundImage, 0, 0, this);
        
        Point tokyo = new Point(440, 155);
        drawClock(TimeZone.getTimeZone("Japan"), tokyo);
        
        Point boulder = new Point(710, 140);
        drawClock(TimeZone.getTimeZone("Mountain Standard Time, America/Denver"), boulder);

        g.drawImage(clockImage, 0, 0, this);
        
        setIconImage(clockImage); // 時計の画像をアイコンとして表示する
        super.paint(g);
    }
    
    private void drawClock(TimeZone tz, Point pt) {
        
        Rectangle2D clockSize = this.getClockSize();
        Point clockPosition = new Point(pt.x - (int)clockSize.getWidth() / 2, pt.y + 6);
        
        // バックグラウンドの表示
        bufGraphics.setColor(config.getBackgroundColor());
        bufGraphics.fillRoundRect(clockPosition.x - 3,
                                  clockPosition.y - 3,
                                  (int)clockSize.getWidth() + 6,
                                  (int)clockSize.getHeight() + 6, 6, 6);
        
        // 時計文字列の表示
        bufGraphics.setColor(config.getFontColor());
        bufGraphics.drawString(config.clock(new GregorianCalendar(tz)),
                               clockPosition.x, 
                               clockPosition.y + (int)clockSize.getHeight() );
        
        // アイコンの表示
        bufGraphics.drawImage(clockiconImage, pt.x, pt.y - 10, this);
        
    }

    public static void main (String args[]) {
        Frame f = new Frame();
        DigitalClock digitalclock = new DigitalClock(f);
        new Thread(digitalclock).start();
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
