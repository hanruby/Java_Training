package ex01_04;

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
        
        config = new Config();
        this.clock = this;

        // If running on the Windows XP, transparent does not support.
        if (System.getProperty("os.name").indexOf("Windows XP") != -1) {
            System.out.println("Running on Windows XP");
            clock.setBackground(new Color(100,0,0));
        }
        else {
            // Transparent
            clock.setBackground(new Color(0,0,0,0));
        }

        createPopupMenu();
        setConfig(config);
        
        addWindowListener(new ClockWindowListener());
        // refer : http://stackoverflow.com/questions/5577619/why-are-mousedragged-events-not-received-when-using-mouseadapter
        ClockMouseListener mouseEvent = new ClockMouseListener(); 
        addMouseListener(mouseEvent);
        addMouseMotionListener(mouseEvent);

        // set new window position
        clock.setLocation(config.getPosition());

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
        clockImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        bufGraphics = (Graphics2D) clockImage.getGraphics();

        bufGraphics.setFont(config.getFont());
        
        // 背景画像の表示
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

    @Override
    public void update(Graphics g) {
        // clearは呼ばない
        this.paint(g);
    }

    public static void main (String args[]) {
        Frame f = new Frame();
        DigitalClock digitalclock = new DigitalClock(f);
        new Thread(digitalclock).start();
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
        
        Point dragStartPos, draggingPos, currentPos;
        int mouseButton;
        
        @Override
        public void mouseClicked(MouseEvent e) {

            // 右クリックでポップアップメニューを開く
            if ( e.getButton() == MouseEvent.BUTTON3) {
                popupmenu.show(e.getComponent(), e.getX(), e.getY());
            }
            super.mouseClicked(e);
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            
            mouseButton = e.getButton();

            // 左ドラッグ開始
            if ( e.getButton() == MouseEvent.BUTTON1) {

                // save drag start position.
                dragStartPos = e.getPoint();
            }
            super.mousePressed(e);
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {

            // 左ドラッグ中
            if ( e.getButton() == MouseEvent.BUTTON1 || mouseButton == MouseEvent.BUTTON1) {
                draggingPos = e.getPoint();
                currentPos = clock.getLocation();
                Point newPos = new Point(currentPos.x + draggingPos.x - dragStartPos.x, currentPos.y + draggingPos.y - dragStartPos.y);
                // set new window position
                clock.setLocation(newPos);
            }
            
            super.mouseDragged(e);
        }
    }

    /**
     * 終了処理
     */
    public void exitProcess() {
        this.config.setPosition(clock.getLocation());
        this.config.savePref();
        System.exit (0);
    }

    /**
     * Windowがクローズされた場合
     * @author ato
     *
     */
    class ClockWindowListener extends WindowAdapter {
        @Override
        public void windowClosing (WindowEvent event) {
            exitProcess();
        }

        @Override
        public void windowClosed(WindowEvent arg0) {
            exitProcess();
        }
    }
}

