package ex03_07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScreenColorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testScreenColor() {
        ScreenColor sc = new ScreenColor("red");
        assertEquals("red", sc.toString());
    }

    @Test
    public void testToString() {
        fail("Not yet implemented");
    }

}
