package practice.ch21_Collections;


import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class ShortStringsTest {

    @Before
    public void setUp() throws Exception {
    }
    
    
    @Test
    public void test_ShortStrings() throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        
        list.add("hoge");
        list.add("fuga");
        list.add("foo");
        list.add("bar");
        
        Iterator<String> it = list.iterator();
        
        ShortStrings strings = new ShortStrings(it, 3);
        
        assertTrue(strings.hasNext());
        assertEquals("foo", strings.next());

        assertTrue(strings.hasNext());
        assertEquals("bar", strings.next());

        assertFalse(strings.hasNext());
}

}
