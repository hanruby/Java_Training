package ch13.ex13_06;

public class NumberUtil {
    
    private final static int DIGITS = 3;
    private final static String SEPARATOR = ",";
    
    static String numberFormatter(String numberString) {
        
        return numberFormatter(numberString, DIGITS, SEPARATOR);
    }
    
    static String numberFormatter(String numberString, int digits, String separator) {
        
        StringBuilder buf = new StringBuilder(numberString);
        
        for (int place = buf.length() - digits; place > 0; place-= digits) {
            buf.insert(place,separator);
        }
        
        return buf.toString();
    }
}
