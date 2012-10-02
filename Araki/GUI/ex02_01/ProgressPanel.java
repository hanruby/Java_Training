package ex02_01;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class ProgressPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = -8483677666452465265L;

    private JSlider slider_hour;
    private JSlider slider_min;
    private JSlider slider_sec;
    
    public ProgressPanel() {

        // 背景をクリア
        this.setBackground(Color.BLACK);

        // hour
        slider_hour = new JSlider(JSlider.HORIZONTAL, 0, 24, 0);
        slider_hour.setMajorTickSpacing(3);
        slider_hour.setMinorTickSpacing(1);
        slider_hour.setPaintTicks(true);
        slider_hour.setPaintLabels(true);
        slider_hour.setEnabled(false);
        slider_hour.setBackground(Color.BLACK);

        // min
        slider_min = new JSlider(JSlider.HORIZONTAL, 0, 60, 0);
        slider_min.setMajorTickSpacing(15);
        slider_min.setMinorTickSpacing(1);
        slider_min.setPaintTicks(true);
        slider_min.setPaintLabels(true);
        slider_min.setEnabled(false);
        slider_min.setBackground(Color.BLACK);

        // sec
        slider_sec = new JSlider(JSlider.HORIZONTAL, 0, 60, 0);
        slider_sec.setMajorTickSpacing(10);
        slider_sec.setMinorTickSpacing(1);
        slider_sec.setPaintTicks(true);
        slider_sec.setPaintLabels(true);
        slider_sec.setEnabled(false);
        slider_sec.setBackground(Color.BLACK);
        
        // layout
        this.setLayout(new GridLayout(3, 1));

        // add
        this.add(slider_hour);
        this.add(slider_min);
        this.add(slider_sec);

        this.updateSlider();
    }

    private void updateSlider() {
        // see http://docs.oracle.com/javase/jp/6/api/java/util/GregorianCalendar.html
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Japan"));
        slider_hour.setValue(calendar.get(Calendar.HOUR_OF_DAY));
        slider_min.setValue(calendar.get(Calendar.MINUTE));
        slider_sec.setValue(calendar.get(Calendar.SECOND));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.updateSlider();
    }
}
