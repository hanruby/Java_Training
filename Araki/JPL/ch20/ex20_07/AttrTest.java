package ch20.ex20_07;


import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Before;
import org.junit.Test;

public class AttrTest {

    @Before
    public void setUp() throws Exception {
    }

    
    @Test
    public void test_writeStream() throws Exception {
        File file = new File("JPL/ch20/ex20_07/out.txt");
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file));

        Attr a = new Attr("hoge","piyo");
        
        a.writeStream(out);

        FileInputStream fis = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fis);
        assertEquals("hoge", in.readUTF());
        assertEquals("piyo", in.readUTF());
    }
}
