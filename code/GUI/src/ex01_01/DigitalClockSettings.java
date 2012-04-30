package ex01_01;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DigitalClockSettings {
    private Format format;
    
    public DigitalClockSettings() {
        format = SimpleDateFormat.getDateTimeInstance(SimpleDateFormat.FULL, SimpleDateFormat.FULL, Locale.JAPAN);
    }
    
    public String dateFormat(Calendar cal) {
        return format.format(cal.getTime());
    }
    
}
