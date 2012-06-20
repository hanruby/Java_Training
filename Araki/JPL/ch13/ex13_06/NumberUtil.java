package ch13.ex13_06;

public class NumberUtil {
    
    private final static int PLACE = 3;
    
    static String numberFormatter(String numberString) {
        
        StringBuilder buf = new StringBuilder(numberString);
        
        for (int place = buf.length() - PLACE; place > 0; place-= PLACE) {
            buf.insert(place,",");
        }
        
        return buf.toString();
    }
}
