package GUI;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MethodUtilityTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void test_execMethod() throws Exception {
        TestMethod t = new TestMethod();
        String ret;
        
        ret = (String) MethodUtility.execMethod(t, 0, "hoge");
        assertEquals("return:hoge", ret);

        ret = (String) MethodUtility.execMethod(t, 1, "hoge,2");
        assertEquals("return:hoge2", ret);

        ret = (String) MethodUtility.execMethod(t, 2, "hoge,2,false");
        assertEquals("return:hoge2false", ret);
    }

}

@SuppressWarnings("unused")
class TestMethod {
    
    private String returnString(String str) {
        return "return:" + str;
    }

    private String returnString(String str, int num) {
        return "return:" + str + num;
    }

    private String returnString(String str, int num, boolean b) {
        return "return:" + str + num + b;
    }
    
}
