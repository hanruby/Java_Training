package ch22.ex22_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Comment {
    
    public static List<String> readTokens(Readable source) {
        
        Scanner in = new Scanner(source);
        
        List<String> tokens = new ArrayList<String>();
        
        Pattern COMMENT = Pattern.compile("#.*", Pattern.MULTILINE);

        @SuppressWarnings("unused")
        String comment;
        
        while (in.hasNext()) {
            if (in.hasNext(COMMENT)) {
                comment = in.findWithinHorizon(COMMENT, 0);
                in.nextLine();
            }
            else {
                tokens.add(in.next());
            }
        }
        return tokens;
    }
}