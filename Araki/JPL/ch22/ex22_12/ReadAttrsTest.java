package ch22.ex22_12;


import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class ReadAttrsTest {

    @Before
    public void setUp() throws Exception {
    }

    
    @Test
    public void testReadAttrs() throws Exception {
        
        StringReader in = new StringReader(
                "#This is test\n" +
                "One=1\n" +
                "Two = 2\n" +
                "Three=三\n"
        );
        
        Attributed attrs = AttributedImpl.readAttrs(in);

        assertEquals(1.0, attrs.find("One").getValue());
        assertEquals(2.0, attrs.find("Two").getValue());
        assertEquals("三", attrs.find("Three").getValue());
    }
}
