package ch20.ex20_01;


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
        OutputStream out = new ByteArrayOutputStream();
        InputStream in = new ByteArrayInputStream("abc".getBytes());
        
        TranslateByte.translate(in, out, (byte)'a',(byte)'A');

        assertEquals("Abc", out.toString());
    }
    
    @Test
    public void testTranslate_02() throws Exception {
        OutputStream out = new ByteArrayOutputStream();
        InputStream in = new ByteArrayInputStream("abcabcabcabc".getBytes());
        
        TranslateByte.translate(in, out, (byte)'b',(byte)'B');

        assertEquals("aBcaBcaBcaBc", out.toString());
    }
}
