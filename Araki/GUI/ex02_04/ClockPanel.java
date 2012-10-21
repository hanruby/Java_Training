package ex02_04;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JPanel;

public class ClockPanel extends JPanel {

    private static final long serialVersionUID = 5748159979557134680L;
    private Config config;

    public ClockPanel(Config config) {
        this.config = config;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;

        paintClock(g);
    }

    private void paintClock(Graphics2D g) {

        // 背景をクリア
        g.setBackground(config.getBackgroundColor());
        g.clearRect(0, 0, getWidth(), getHeight());

        // 時計文字描画
        g.setPaint(config.getFontColor());
        g.drawString(config.clock(new GregorianCalendar(TimeZone
                .getTimeZone("Japan"))), 100, 20);
    }
}
