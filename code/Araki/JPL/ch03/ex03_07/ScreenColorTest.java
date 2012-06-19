package ch03.ex03_07;

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
        ScreenColor sc = new ScreenColor("red");
        assertEquals("red", sc.toString());
    }
    
    @Test
    public void testEquals() throws Exception {
        ScreenColor sc1 = new ScreenColor("red");
        ScreenColor sc2 = new ScreenColor("red");
        ScreenColor sc3 = new ScreenColor("green");

        assertTrue(sc1.equals(sc2));
        assertFalse(sc1.equals(sc3));
    }
    
    @Test
    public void testHashcode() throws Exception {
        ScreenColor sc1 = new ScreenColor("red");
        ScreenColor sc2 = new ScreenColor("red");
        ScreenColor sc3 = new ScreenColor("blue");
        
        assertEquals(sc1.hashCode(), sc2.hashCode());
        assertNotSame(sc1.hashCode(), sc3.hashCode());
    }

}
