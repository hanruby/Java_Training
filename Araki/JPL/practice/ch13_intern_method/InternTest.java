package practice.ch13_intern_method;


import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class InternTest {

    @Test
    public void testIntern() throws Exception {
        
        String a = "haha";

        String x = "haha";
        String y = "ha";

        // internすると同じオブジェクト
        assertSame(x, (y+y).intern());
        assertTrue(x == (y+y).intern());

        // y+yだと違う
        assertNotSame(x, (y+y));
        assertNotSame(x, new String(y+y));
        assertFalse(x == (y+y));
        assertTrue(x.equals(y+y)); // equalsを使えばtrue
        
        // StringBuilderしても違う       
        StringBuilder builder = new StringBuilder();
        builder.append(y);
        builder.append(y);
        assertNotSame(x, builder.toString());
        assertSame(x, builder.toString().intern());
        
        // いま存在していない"hahaha"
        String yyy = (y+y+y).intern();
        assertSame("hahaha", yyy);
        
    }
    
    private String myIntern(String str) {
        return null;
    }
}
