package ex02_01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JPanel;

public class ClockPanel extends JPanel {

    private static final long serialVersionUID = 5748159979557134680L;
    private Config config;
    
    public ClockPanel() {
        config = new Config();
        
        this.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;

        paintClock(g);
    }
    
    private void paintClock(Graphics2D g) {
        
        // 背景をクリア
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, getWidth(), getHeight());
        
        // 時計文字描画
        g.setPaint(Color.BLACK);
        g.drawString(config.clock(new GregorianCalendar(TimeZone
                .getTimeZone("Japan"))), 100, 20);
    }
}
