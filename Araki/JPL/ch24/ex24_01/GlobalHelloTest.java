package ch24.ex24_01;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GlobalHelloTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUsage() throws Exception {
        GlobalHello.main(new String[]{});
    }
}
