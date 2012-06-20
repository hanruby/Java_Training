package ch13.ex13_05;

public class NumberUtil {
    
    private final static int DIGITS = 3;
    
    static String numberFormatter(String numberString) {
        
        StringBuilder buf = new StringBuilder(numberString);
        
        for (int place = buf.length() - DIGITS; place > 0; place-= DIGITS) {
            buf.insert(place,",");
        }
        
        return buf.toString();
    }
}
