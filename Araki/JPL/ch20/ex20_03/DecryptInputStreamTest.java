package ch20.ex20_03;


import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.junit.Before;
import org.junit.Test;

public class DecryptInputStreamTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDecrypt() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(2); 
                
        InputStream in = new ByteArrayInputStream(new byte[]{0x00,0x11});
        DecryptInputStream decrypt = new DecryptInputStream(in);
        
        int b;
        while( (b = decrypt.read()) != -1 ) {
            buffer.put((byte)b);
        }
        
        assertArrayEquals(new byte[]{(byte) 0xAB,(byte) 0xBA}, buffer.array());
    }
}
