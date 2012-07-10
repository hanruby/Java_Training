package ch14.ex14_07;


//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BabbleTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDoYieldFalse() throws Exception {
        String[] args = new String[]{"false","2","A","B"};
        System.out.println(StringUtility.join(args));
        Babble.main(args);
    }
    
    @Test
    public void testDoYieldTrue() throws Exception {
        String[] args = new String[]{"true","2","A","B"};
        System.out.println(StringUtility.join(args));
        Babble.main(args);
    }
}


class StringUtility {
    public static String join(String str, String... strings) {
        StringBuffer buf = new StringBuffer();
        for (String s: strings) {
            if (buf.length() > 0) {
                buf.append(str);
                buf.append(" ");
            }
            buf.append(s);
        }
        return buf.toString();
    }

    public static String join(String[] strings) {
        StringBuffer buf = new StringBuffer();
        if (strings != null && strings.length > 0) {
            for (String s: strings) {
                buf.append(s);
                buf.append(" ");
            }
        }
        return buf.toString();
    }
}
