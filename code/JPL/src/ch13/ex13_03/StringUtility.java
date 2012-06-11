package ch13.ex13_03;

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
}
