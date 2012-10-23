package ex02_04;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class ProgressPanel extends JPanel {

    private static final long serialVersionUID = -8483677666452465265L;

    private static JSlider slider_hour = new JSlider(JSlider.HORIZONTAL, 0, 24, 0);
    private static JSlider slider_min = new JSlider(JSlider.HORIZONTAL, 0, 60, 0);
    private static JSlider slider_sec= new JSlider(JSlider.HORIZONTAL, 0, 60, 0);

    public ProgressPanel(Config config) {

        // hour
        slider_hour.setMajorTickSpacing(3);
        slider_hour.setMinorTickSpacing(1);
        slider_hour.setPaintTicks(true);
        slider_hour.setPaintLabels(true);
        slider_hour.setEnabled(false);

        // min
        slider_min.setMajorTickSpacing(15);
        slider_min.setMinorTickSpacing(1);
        slider_min.setPaintTicks(true);
        slider_min.setPaintLabels(true);
        slider_min.setEnabled(false);

        // sec
        slider_sec.setMajorTickSpacing(10);
        slider_sec.setMinorTickSpacing(1);
        slider_sec.setPaintTicks(true);
        slider_sec.setPaintLabels(true);
        slider_sec.setEnabled(false);

        this.setBackground(config.getBackgroundColor());
        
        // layout
        this.setLayout(new GridLayout(3, 1));

        // add
        this.add(slider_hour);
        this.add(slider_min);
        this.add(slider_sec);

        this.updateSlider();
    }
    
    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        slider_hour.setBackground(bg);
        slider_min.setBackground(bg);
        slider_sec.setBackground(bg);
    }

    public void updateSlider() {
        // see
        // http://docs.oracle.com/javase/jp/6/api/java/util/GregorianCalendar.html
        GregorianCalendar calendar = new GregorianCalendar(
                TimeZone.getTimeZone("Japan"));
        slider_hour.setValue(calendar.get(Calendar.HOUR_OF_DAY));
        slider_min.setValue(calendar.get(Calendar.MINUTE));
        slider_sec.setValue(calendar.get(Calendar.SECOND));
    }
    
    @Override
    public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(l);
        slider_hour.addMouseListener(l);
        slider_min.addMouseListener(l);
        slider_sec.addMouseListener(l);
    }
    
    @Override
    public synchronized void addMouseMotionListener(MouseMotionListener l) {
        super.addMouseMotionListener(l);
        slider_hour.addMouseMotionListener(l);
        slider_min.addMouseMotionListener(l);
        slider_sec.addMouseMotionListener(l);
    }
}
