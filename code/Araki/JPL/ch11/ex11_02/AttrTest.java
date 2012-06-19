package ch11.ex11_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttrTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAttrString() {
        Attr<String> at = new Attr<String>("test");
        assertEquals("test", at.getName());
    }

    @Test
    public void testAttrStringObject() {
        String str = new String();
        Attr<String> at = new Attr<String>("test", str);
        assertEquals(str, at.getValue());
    }

    @Test
    public void testGetName() {
        Attr<String> at = new Attr<String>("test");
        assertEquals("test", at.getName());
    }

    @Test
    public void testGetValue1() {
        Attr<String> at = new Attr<String>("test");
        assertEquals(null, at.getValue());
    }
    @Test
    public void testGetValue2() {
        String str = new String();
        Attr<String> at = new Attr<String>("test", str);
        assertEquals(str, at.getValue());
    }

    @Test
    public void testSetValue1() {
        Attr<Object> at = new Attr<Object>("test");
        Object obj = new Object();
        Object ret = at.setValue(obj);
        assertEquals(obj, at.getValue());
        assertEquals(ret, null);
    }
    @Test
    public void testSetValue2() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        Attr<Object> at = new Attr<Object>("test", obj1);
        Object ret = at.setValue(obj2);
        assertEquals(obj2, at.getValue());
        assertEquals(ret, obj1);
    }

    @Test
    public void testToString() {
        String str = "string";
        Attr<String> at = new Attr<String>("test", str);
        assertEquals("test='string'", at.toString());
    }
}
