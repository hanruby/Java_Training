package ex01_01;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClockSettings {
    private SimpleDateFormat dateFormat;
    
    public DigitalClockSettings() {
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); //
    }
    
    public String dateFormat(Calendar cal) {
        return dateFormat.format(cal.getTime());
    }
    
}
