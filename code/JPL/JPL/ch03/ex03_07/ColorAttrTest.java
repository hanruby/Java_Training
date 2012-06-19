package ch03.ex03_07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ColorAttrTest {

    @Before
    public void setUp() throws Exception {
    }

    String red   = "red";        
    String blue  = "blue";        
    String green = "green";        
    ScreenColor scRed   = new ScreenColor("red");
    ScreenColor scBlue  = new ScreenColor("blue");    
    ScreenColor scGreen = new ScreenColor("green");    

    @Test
    public void testColorAttrString() {
        ColorAttr at = new ColorAttr("name");

        assertEquals("name", at.getName());
        assertEquals("transparent", at.getColor().toString());
    }

    @Test
    public void testColorAttrStringObject() {
        ColorAttr at = new ColorAttr("name", red);

        assertEquals("name", at.getName());
        assertEquals(red, at.getValue());
    }

    @Test
    public void testColorAttrStringScreenColor() {
        ColorAttr at = new ColorAttr("name", scRed);

        assertEquals("name", at.getName());
        assertEquals(scRed, at.getColor());
        assertEquals(scRed.toString(), at.getValue());
    }

    @Test
    public void testSetValueObject() {
        ColorAttr at = new ColorAttr("name", scRed);
        
        assertEquals(red, at.setValue(blue));	
        assertEquals(blue, at.setValue(green));	
        assertEquals(green, at.setValue(red));	
    }

    @Test
    public void testSetValueScreenColor() {
        ColorAttr at = new ColorAttr("name", scRed);
        
        assertEquals(scRed, at.setValue(scBlue));
        assertEquals(scBlue, at.setValue(scGreen));
        assertEquals(scGreen, at.setValue(scRed));
    }

    @Test
    public void testGetColor() {
        ColorAttr at = new ColorAttr("name", scRed);
        
        assertEquals(scRed, at.getColor());
    }

    @Test
    public void testDecodeColor() {
        ColorAttr at = new ColorAttr("name", red);
        
        assertEquals("red", at.getColor().toString());
    }
    
    @Test
    public void testEquals() throws Exception {
        ColorAttr at1 = new ColorAttr("name", red);
        ColorAttr at2 = new ColorAttr("name", red);
        ColorAttr at3 = new ColorAttr("name", green);
        
        assertTrue(at1.equals(at2));
        assertFalse(at1.equals(at3));
    }
    
    @Test
    public void testHashcode() throws Exception {
        ColorAttr at1 = new ColorAttr("name", red);
        ColorAttr at2 = new ColorAttr("name", red);
        ColorAttr at3 = new ColorAttr("name", green);

        assertEquals(at1.hashCode(), at2.hashCode());
        assertNotSame(at1.hashCode(), at3.hashCode());
    }

}
