package ex01_01;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Config {
    private Format format;
    
    public Config() {
        format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    }
    
    public String dateFormat(Calendar cal) {
        return format.format(cal.getTime());
    }
    
}
