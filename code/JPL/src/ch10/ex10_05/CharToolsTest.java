package ch10.ex10_05;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CharToolsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFillChar() throws Exception {
        assertEquals("abc", CharTools.fill('a', 'c'));
        assertEquals("a", CharTools.fill('a', 'a'));
        assertEquals("abc", CharTools.fill('c', 'a'));
        assertEquals("defg", CharTools.fill('d', 'g'));
        //assertEquals("あいう", CharTools.fill('あ', 'う'));
    }
}
