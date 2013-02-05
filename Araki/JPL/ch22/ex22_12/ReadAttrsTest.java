package ch22.ex22_12;


import static org.junit.Assert.*;

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

public class ReadAttrsTest {

    @Before
    public void setUp() throws Exception {
    }

    
    @Test
    public void testReadAttrs() throws Exception {
        
        StringReader in = new StringReader(
                "#3 attrs\n" +
                "One=1\n" +
                "Two=2\n" +
                "Three=三\n"
        );
        
        Attributed attrs = AttributedImpl.readAttrs(in);

        assertEquals(1.0, attrs.find("One").getValue());
        assertEquals(2.0, attrs.find("Two").getValue());
        assertEquals("三", attrs.find("Three").getValue());
    }
    
    @Test
    public void testReadAttrs2() throws Exception {
        
        StringReader in = new StringReader(
                "3 attrs\n" +
                "One=1\n" +
                "Two=2\n" +
                "Three=三\n"
        );
        
        Attributed attrs = AttributedImpl.readAttrs2(in);

        assertEquals("1", attrs.find("One").getValue());
        assertEquals("2", attrs.find("Two").getValue());
        assertEquals("三", attrs.find("Three").getValue());
    }
    
    @Test
    public void testPrintAttrs() throws Exception {
        StringWriter out = new StringWriter();
        
        Attr[] attrs = new Attr[3];
        attrs[0] = new Attr("いち", "1"); 
        attrs[1] = new Attr("に", "2");
        attrs[2] = new Attr("さん", "3");
        
        AttributedImpl.printAttrs(out, attrs);
        
        String expected = "3 attrs\n" +
                          "いち=1\n" +
                          "に=2\n" +
                          "さん=3\n"; 
            
        assertEquals(expected, out.toString());
    }
    
    @Test
    public void testScanAttrs() throws Exception {
        StringReader in = new StringReader(
                "3 attrs\n" +
                "いち=1\n" +
                "に=2\n" +
                "さん=3\n");
        
        Attr[] attrs = AttributedImpl.scanAttrs(in);
        
        assertEquals("いち", attrs[0].getName());
        assertEquals("1", attrs[0].getValue());
        assertEquals("に", attrs[1].getName());
        assertEquals("2", attrs[1].getValue());
        assertEquals("さん", attrs[2].getName());
        assertEquals("3", attrs[2].getValue());
    }
}
