package ex02_04;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

public class DigitalClock extends JWindow implements ActionListener {

    private static final long serialVersionUID = 1362097885644824584L;
    private static final int DEFAULT_WIDTH = 320;
    private static final int DEFAULT_HEIGHT = 240;

    private Timer time;

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

        // set params
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.setLocationRelativeTo(null);
        Container contentPane = this.getContentPane();

        // Add ProgressPanel
        ProgressPanel progressPanel = new ProgressPanel();
        progressPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH,
                (int) (DEFAULT_HEIGHT * 0.8)));
        contentPane.add(progressPanel, BorderLayout.NORTH);

        // Add ClockPanel
        ClockPanel clockPanel = new ClockPanel();
        clockPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH,
                (int) (DEFAULT_HEIGHT * 0.1)));
        contentPane.add(clockPanel, BorderLayout.SOUTH);

        time = new Timer(1000, (ActionListener) this);
        time.addActionListener(progressPanel);
        time.start();

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
