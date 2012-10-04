package ch22.ex22_10;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Comment {
    public static void readTokens(Readable source) {
        
        Scanner in = new Scanner(source);
        Pattern COMMENT = Pattern.compile("#.*");
        String comment;
        // ...
        while (in.hasNext()) {
            if (in.hasNext(COMMENT)) {
                comment = in.findWithinHorizon(COMMENT, 0);
                in.nextLine();
            }
            else {

            }
        }
    }
}
