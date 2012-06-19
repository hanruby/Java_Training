package ch03.ex03_07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttrTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAttrString() {
        Attr at = new Attr("test");
        assertEquals("test", at.getName());
    }

    @Test
    public void testAttrStringObject() {
        Object obj = new Object();
        Attr at = new Attr("test", obj);
        assertEquals(obj, at.getValue());
    }

    @Test
    public void testGetName() {
        Attr at = new Attr("test");
        assertEquals("test", at.getName());
    }

    @Test
    public void testGetValue1() {
        Attr at = new Attr("test");
        assertEquals(null, at.getValue());
    }
    @Test
    public void testGetValue2() {
        Object obj = new Object();
        Attr at = new Attr("test", obj);
        assertEquals(obj, at.getValue());
    }

    @Test
    public void testSetValue1() {
        Attr at = new Attr("test");
        Object obj = new Object();
        Object ret = at.setValue(obj);
        assertEquals(obj, at.getValue());
        assertEquals(ret, null);
    }
    @Test
    public void testSetValue2() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        Attr at = new Attr("test", obj1);
        Object ret = at.setValue(obj2);
        assertEquals(obj2, at.getValue());
        assertEquals(ret, obj1);
    }

    @Test
    public void testToString() {
        String str = "string";
        Attr at = new Attr("test", str);
        assertEquals("test='string'", at.toString());
    }
    
    @Test
    public void testEquals() throws Exception {
        Attr at1 = new Attr("test");
        Attr at2 = new Attr("test");
        Attr at3 = new Attr("hoge");
        
        assertTrue(at1.equals(at2));
        assertFalse(at1.equals(at3));
    }

    @Test
    public void testHashcode() throws Exception {
        Attr at1 = new Attr("test");
        Attr at2 = new Attr("test");
        Attr at3 = new Attr("hoge");

        assertEquals(at1.hashCode(), at2.hashCode());
        assertNotSame(at1.hashCode(), at3.hashCode());
    }
}
