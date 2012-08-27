package ch20.ex20_04;


import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class LineFilterReaderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testReadLine() throws Exception {
        StringReader in = new StringReader("aaa\nbbb\rccc\r\nddd\n\n");
        
        LineFilterReader lineFilterReader = new LineFilterReader(in); 
        
        assertEquals("aaa", lineFilterReader.readLine());
        assertEquals("bbb", lineFilterReader.readLine());
        assertEquals("ccc", lineFilterReader.readLine());
        assertEquals("ddd", lineFilterReader.readLine());
        assertEquals("", lineFilterReader.readLine());
        
        
    } 
}
