package ch20.ex20_03;


import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

public class EncryptOutputStreamTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testEncrypt() throws Exception {
        
        byte[] test = {(byte) 0xAB, (byte) 0xBA};
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        EncryptOutputStream encrypt = new EncryptOutputStream(out);
        
        encrypt.write(test);
        
        assertArrayEquals(new byte[]{0x00, 0x11}, out.toByteArray());
        
    }
}
