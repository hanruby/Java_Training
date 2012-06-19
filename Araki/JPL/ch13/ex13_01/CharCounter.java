package ch13.ex13_01;

public class CharCounter {
    
    static int countChar(String str, char c) {
        if( str == null ) {
            throw new NullPointerException();
        }
        
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if( str.charAt(i) == c ) count++;
        }
        
        return count;
    }
}
