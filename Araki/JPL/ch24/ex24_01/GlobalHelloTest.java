package ch24.ex24_01;


import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class GlobalHelloTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_JAPAN() throws Exception {
        
        Locale.setDefault(Locale.JAPAN);
        GlobalHello.main(new String[]{});
    }

    @Test
    public void test_ENGLISH() throws Exception {
        
        Locale.setDefault(Locale.ENGLISH);
        GlobalHello.main(new String[]{});
    }
}
