package ch22.ex22_14;

import java.util.StringTokenizer;

public class DoubleUtil {
    
    public static double sum(String str) 
    {
        StringTokenizer tokens = new StringTokenizer(str, " ");
        double sum = 0;
        
        while (tokens.hasMoreTokens()){
            sum += Double.valueOf(tokens.nextToken());
        }
        
        return sum;
    }
}
