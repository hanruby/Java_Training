package ch16.ex16_05;

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
    public void testSearchType() throws Exception {

        // Expected
        _out.println("  public void ch16.ex16_03.A.methodA()");
        _out.println("  public void ch16.ex16_03.X.methodX()");
        _out.flush();
        
        Class<?> startClass = Class.forName("ch16.ex16_03.X");

        ClassContents.searchType(startClass);
        ClassContents.showMembers();
        
        cc.getOut().flush();
        assertEquals(_expected.toString(), _actual.toString());
    }
    
    @Test
    public void testStrip() {
        assertEquals("HashMap", ClassContents.strip("java.lang.HashMap", "java.lang."));
        assertEquals("  HashMap", ClassContents.strip("  java.lang.HashMap", "java.lang."));
        assertEquals("  ", ClassContents.strip("  java.lang.", "java.lang."));
    }
}



class A {
    public void methodA(){};
}

class X extends A { 
    public void methodX(){};
}
