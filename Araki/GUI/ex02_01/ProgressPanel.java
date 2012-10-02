package ex02_01;

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

        {     
            // hour
            slider_hour = new JSlider(JSlider.HORIZONTAL, 0, 24, 0);
            slider_hour.setMajorTickSpacing(12);
            slider_hour.setMinorTickSpacing(1);
            slider_hour.setPaintTicks(true);
            slider_hour.setPaintLabels(true);

            // min
            slider_min = new JSlider(JSlider.HORIZONTAL, 0, 60, 0);
            slider_min.setMajorTickSpacing(15);
            slider_min.setMinorTickSpacing(1);
            slider_min.setPaintTicks(true);
            slider_min.setPaintLabels(true);

            // sec
            slider_sec = new JSlider(JSlider.HORIZONTAL, 0, 60, 0);
            slider_sec.setMajorTickSpacing(10);
            slider_sec.setMinorTickSpacing(1);
            slider_sec.setPaintTicks(true);
            slider_sec.setPaintLabels(true);
        }
        
        // layout
        this.setLayout(new GridLayout(3, 1));

        // add
        this.add(slider_hour);
        this.add(slider_min);
        this.add(slider_sec);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Japan"));
        slider_hour.setValue(calendar.get(Calendar.HOUR));
        slider_min.setValue(calendar.get(Calendar.MINUTE));
        slider_sec.setValue(calendar.get(Calendar.SECOND));
    }
}
