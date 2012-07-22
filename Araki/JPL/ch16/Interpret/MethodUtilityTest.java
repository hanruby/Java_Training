package ch16.Interpret;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MethodUtilityTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void test_execMethod() throws Exception {
        TestClass t = new TestClass();
        String ret;
        
        ret = (String) MethodUtility.execMethod(t, 0, "hoge");
        assertEquals("return:hoge", ret);

        ret = (String) MethodUtility.execMethod(t, 1, "hoge,2");
        assertEquals("return:hoge2", ret);
    }

}

@SuppressWarnings("unused")
class TestClass {
    
    private String returnString(String str) {
        return "return:" + str;
    }

    private String returnString(String str, int num) {
        return "return:" + str + num;
    }
    
}
