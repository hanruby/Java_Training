package ch24.ex24_01;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class GlobalHelloTest {

    private Locale locale;
    private String key;
    private String expected;
    
    public GlobalHelloTest(Locale locale, String key, String expected) {
        this.locale = locale;
        this.key = key;
        this.expected = expected;
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        // テストする各オブジェクトをここに追加する
        Object[][] data = new Object[][] {
                {Locale.JAPAN, GlobalRes.HELLO, "こんにちは"},
                {Locale.KOREA, GlobalRes.HELLO, "안녕하세요"},
                {Locale.ENGLISH, GlobalRes.HELLO, "hello"},
        };
        return Arrays.asList(data);
    }
    
    @Test
    public void test_JAPAN() throws Exception {
        Locale.setDefault(locale);
        
        ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes");
        assertEquals(expected, res.getString(key));
    }   
}
