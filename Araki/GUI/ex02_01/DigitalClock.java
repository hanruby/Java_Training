package ex02_01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class DigitalClock extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1362097885644824584L;
    private static final String TITLE = "@atotto's Digital Clock";
    private static final int DEFAULT_WIDTH = 320;
    private static final int DEFAULT_HEIGHT = 240;

    private Config config;

    private Timer time = new Timer(5, (ActionListener) this);

    public static void main(String[] args) {
        new DigitalClock();
    }

    public DigitalClock() {
        config = new Config();

        // set params
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        this.setLocationRelativeTo(null);
        Container contentPane = this.getContentPane();
        
        // Add ProgressPanel
        ProgressPanel progressPanel = new ProgressPanel();
        progressPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH, (int)(DEFAULT_HEIGHT*0.8)));
        contentPane.add(progressPanel, BorderLayout.NORTH);
        
        // Add ClockPanel
        ClockPanel clockPanel = new ClockPanel();
        clockPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH, (int)(DEFAULT_HEIGHT*0.1)));
        contentPane.add(clockPanel, BorderLayout.SOUTH);
        
        time.addActionListener(progressPanel);
        time.start();
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
