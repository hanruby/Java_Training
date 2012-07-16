package ch16.ex16_03;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class ClassContentsTest {

    ClassContents cc = new ClassContents();
    
    private ByteArrayOutputStream _actual;
    
    private ByteArrayOutputStream _expected;
    private PrintStream _out;

    @Before
    public void setUp() throws Exception {
        _actual = new ByteArrayOutputStream();
        _expected = new ByteArrayOutputStream();
        
        cc.setOut(new PrintStream(new BufferedOutputStream(_actual)));
        _out = new PrintStream(new BufferedOutputStream(_expected));
    }

    @Test
    public void test1() throws Exception {
        try {
            Class<?> c = Class.forName("java.util.HashMap");
            ClassContents.outputMembers(c.getFields());
            ClassContents.outputMembers(c.getConstructors());
            ClassContents.outputMembers(c.getMethods());

        } catch (ClassNotFoundException e) {
            System.out.println("unknown class : " + e);
        }
        
        cc.getOut().flush();
        //System.out.println(_actual.toString());
    }
    
    @Test
    public void testSearchType() throws Exception {
        Class<?> startClass = Class.forName("java.util.HashMap");

        ClassContents.searchType(startClass);
        ClassContents.showMembers();
        
        cc.getOut().flush();
        System.out.println(_actual.toString());
    }
    
    @Test
    public void testStrip() {
        assertEquals("HashMap", ClassContents.strip("java.lang.HashMap", "java.lang."));
        assertEquals("  HashMap", ClassContents.strip("  java.lang.HashMap", "java.lang."));
        assertEquals("  ", ClassContents.strip("  java.lang.", "java.lang."));
    }
}
