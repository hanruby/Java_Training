package ex02_04;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
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
        Point pt = new Point(getWidth()/2, 20);

        // 背景をクリア
        g.setBackground(config.getBackgroundColor());
        g.clearRect(0, 0, getWidth(), getHeight());

        // Font settings
        g.setFont(config.getFont());
        g.setPaint(config.getFontColor());
        
        // 時計文字描画
        Rectangle2D clockSize = this.getClockSize();
        Point clockPosition = new Point(pt.x - (int)clockSize.getWidth() / 2, pt.y + 6);
   
        g.drawString(config.clock(new GregorianCalendar(TimeZone
                .getTimeZone("Japan"))),
                clockPosition.x, 
                clockPosition.y + (int)clockSize.getHeight() );
    }

    private Rectangle2D getClockSize() {
        return new TextLayout("0000/00/00 00:00:00", config.getFont(), ((Graphics2D)this.getGraphics()).getFontRenderContext()).getBounds();
    }

}
