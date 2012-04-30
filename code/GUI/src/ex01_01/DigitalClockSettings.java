package ex01_01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClockSettings {
    private SimpleDateFormat dateFormat;
    
    public DigitalClockSettings() {
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    }
    
    public String dateFormat(Date date) {
        return dateFormat.format(date);
    }
    
}
