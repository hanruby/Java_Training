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
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream out = new DataOutputStream(fos);

        Attr a = new Attr("hoge","piyo");
        
        a.writeStream(out);

        FileInputStream fis = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fis);
        assertEquals("hoge", in.readUTF());
        assertEquals("piyo", in.readUTF());
        
        file.delete();
    }
    
    @Test
    public void test_Attr_constructor_read_from_DataInputStream() throws Exception {
        File file = new File("JPL/ch20/ex20_07/in.txt");
        FileInputStream fis = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fis);
        
        Attr a = new Attr(in);
        
        assertEquals("hoge", a.getName());
        assertEquals("piyo", a.getValue());
    }
    
    @Test
    public void test_Attr_constructor_read_from_DataInputStream_when_Object() throws Exception {
        {
            File file = new File("JPL/ch20/ex20_07/out.txt");
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream out = new DataOutputStream(fos);

            Attr a = new Attr("hoge",10.0);

            a.writeStream(out);
        }
        {
            File file = new File("JPL/ch20/ex20_07/out.txt");
            FileInputStream fis = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fis);

            Attr a = new Attr(in);

            assertEquals("hoge", a.getName());
            assertEquals(10.0, a.getValue());
        }
    }

}
