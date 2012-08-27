package ch20.ex20_02;


import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;

public class TranslateByteTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testTranslate_01() throws Exception {
        StringBuilder builder = new StringBuilder();
        InputStream in = new ByteArrayInputStream("abc".getBytes());
        
        TranslateByte tb = new TranslateByte(in, (byte)'a',(byte)'A');
        
        int c;
        while( (c = tb.read()) != -1 ) {
            builder.append((char)c);
        }

        assertEquals("Abc", builder.toString());
    }
    
    @Test
    public void testTranslate_02() throws Exception {
        StringBuilder builder = new StringBuilder();
        InputStream in = new ByteArrayInputStream("abcabcabcabc".getBytes());
        
        TranslateByte tb = new TranslateByte(in, (byte)'b',(byte)'B');
        
        int c;
        while( (c = tb.read()) != -1 ) {
            builder.append((char)c);
        }

        assertEquals("aBcaBcaBcaBc", builder.toString());
    }
}
