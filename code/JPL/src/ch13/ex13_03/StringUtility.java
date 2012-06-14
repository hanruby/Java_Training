package ch13.ex13_03;

import java.util.List;
import java.util.ArrayList;

public class StringUtility {

    public static String delimitedString(String from, char start, char end) {
        
        int startPos = from.indexOf(start);
        int endPos = from.lastIndexOf(end);
        if (startPos == -1) 
            return null;
        else if (endPos == -1)
            return from.substring(startPos);
        else if (startPos > endPos)
            return null;
        else
            return from.substring(startPos, endPos + 1);
    }

    public static String[] delimitedStrings(String from, char start, char end) {

        int startPos = 0;
        int endPos = 0;
        
        List<String> results = new ArrayList<String>();

        for(;;) {
            startPos = from.indexOf(start, endPos);
            endPos = from.indexOf(end, startPos);
            
            if (startPos > endPos) {
                results.add(null);
                break;
            }
            if (startPos == -1 || endPos == -1) {
                results.add(null);
                break;
            }
            else {
                results.add(from.substring(startPos, endPos + 1));
            }
        }
        
        return results.toArray(new String[]{});
    }
}
