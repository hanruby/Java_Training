package ex02_04;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

public class DigitalClock extends JWindow implements ActionListener {

    private static final long serialVersionUID = 1362097885644824584L;
    private static final int DEFAULT_WIDTH = 320;
    private static final int DEFAULT_HEIGHT = 240;

    private Timer time;
    private Config config;
        
    private JPopupMenu popupmenu;
    
    public static void main(String[] args) {
        new DigitalClock();
    }

    public DigitalClock() {

        // set LAF to default
        String lafClassName = "javax.swing.plaf.metal.MetalLookAndFeel";
        try {
            UIManager.setLookAndFeel(lafClassName);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        config = new Config();
        new ConfigObserver(config);
                        
        // set params
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.setLocation(config.getPosition());

        Container contentPane = this.getContentPane();

        // Add ProgressPanel
        ProgressPanel progressPanel = new ProgressPanel();
        progressPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH,
                (int) (DEFAULT_HEIGHT * 0.8)));
        contentPane.add(progressPanel, BorderLayout.NORTH);

        // Add ClockPanel
        ClockPanel clockPanel = new ClockPanel(config);
        clockPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH,
                (int) (DEFAULT_HEIGHT * 0.2)));
        contentPane.add(clockPanel, BorderLayout.SOUTH);
        
        // Event
        addWindowListener(new ClockWindowListener());
        MouseListener mouseEvent = new MouseListener();
        addMouseListener(mouseEvent);
        addMouseMotionListener(mouseEvent);

        time = new Timer(1000, (ActionListener) this);
        time.addActionListener(progressPanel);
        time.start();
        
        popupmenu = createMenuBar();

        this.setVisible(true);
    }

    private JPopupMenu createMenuBar(){
        JMenuItem propertiesMenu = new JMenuItem("Properties");
        propertiesMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new PropertiesDialog(config);
                
            }
        });

        JMenuItem quitMenu = new JMenuItem("Quit");
        quitMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                exitProcess();
            }
        });

        JPopupMenu menuBar = new JPopupMenu();

        menuBar.add(propertiesMenu);
        menuBar.add(quitMenu);

        return menuBar;
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    class MouseListener extends MouseAdapter {
        
        Point dragStartPos, draggingPos, currentPos;
        int mouseButton;
        
        @Override
        public void mouseClicked(MouseEvent e) {

            // 右クリックでポップアップメニューを開く
            if ( e.getButton() == MouseEvent.BUTTON3) {
                DigitalClock.this.popupmenu.show(e.getComponent(), e.getX(), e.getY());
                
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
                currentPos = DigitalClock.this.getLocation();
                Point newPos = new Point(currentPos.x + draggingPos.x - dragStartPos.x, currentPos.y + draggingPos.y - dragStartPos.y);
                // set new window position
                DigitalClock.this.setLocation(newPos);
            }
            
            super.mouseDragged(e);
        }
    }
    
    /**
     * 終了処理
     */
    public void exitProcess() {
        this.config.setPosition(this.getLocation());
        this.config.savePref();
        System.out.println("exit.");
        System.exit (0);
    }

    /**
     * Windowがクローズされた場合
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
    
    class ConfigObserver implements Observer {
        Config watching;
        
        public ConfigObserver(Config config) {
            watching = config; 
            watching.addObserver(this);
        }

        @Override
        public void update(Observable config, Object contents) {
            if (config != watching) {
                throw new IllegalArgumentException("Config object does not same.");
            }
            
            // When config are changed, repaint this window
            DigitalClock.this.repaint();
        }
    }
}



