package ch13.ex13_02;

public class StringCounter {
    
    static int countStr(String str, String word) {
        if( str == null || word == null) {
            throw new NullPointerException();
        }
        
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            int pos = 0;
            for (;;) {
                if( i+pos >= str.length() || str.charAt(i+pos) !=  word.charAt(pos) ) {
                    break;
                }
                pos++;
                if (pos >= word.length()) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}
