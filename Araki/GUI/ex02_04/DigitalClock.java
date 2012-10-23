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

public class DigitalClock extends JWindow {

    private static final long serialVersionUID = 1362097885644824584L;

    private Config config;
        
    private JPopupMenu popupmenu;
    private ClockPanel clockPanel;
    private ProgressPanel progressPanel;
    
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
        this.setLocation(config.getPosition());

        Container contentPane = this.getContentPane();
        
        // Add ProgressPanel
        progressPanel = new ProgressPanel(config);
        progressPanel.setPreferredSize(new Dimension(320,
                (int) (200)));
        contentPane.add(progressPanel, BorderLayout.NORTH);

        // Add ClockPanel
        clockPanel = new ClockPanel(config);
        contentPane.add(clockPanel, BorderLayout.SOUTH);

        pack();
        this.setClockRegion();
        
        // Event
        addWindowListener(new LocalWindowListener());
        LocalMouseListener mouseEvent = new LocalMouseListener();
        addMouseListener(mouseEvent);
        addMouseMotionListener(mouseEvent);

        // 1 sec 
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                progressPanel.updateSlider();
            }
        }).start();
        
        popupmenu = createMenuBar();

        pack();
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
    
    private void setClockRegion() {

        clockPanel.setSize(clockPanel.getPreferredSize());
        pack();
    }
    
    class LocalMouseListener extends MouseAdapter {
        
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
    class LocalWindowListener extends WindowAdapter {
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
            
            String change = (String)contents;
            
            if (change.equals("font") || change.equals("all") ) {
                DigitalClock.this.setClockRegion();
            }
            
            // When config are changed, repaint this window
            DigitalClock.this.repaint();
            DigitalClock.this.progressPanel.setBackground(DigitalClock.this.config.getBackgroundColor());
        }
    }
}



