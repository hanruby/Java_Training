package ch24.ex24_01;


import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

public class GlobalHelloTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_JAPAN() throws Exception {
        Locale.setDefault(Locale.JAPAN);
        
        ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes");
        assertEquals("こんにちは", res.getString(GlobalRes.HELLO));
    }

    @Test
    public void test_ENGLISH() throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        
        ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes");
        assertEquals("hello", res.getString(GlobalRes.HELLO));
    }
}
