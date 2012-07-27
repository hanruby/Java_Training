package ch16.ex16_09;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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
        _out.println("  public void ch16.ex16_05.A.methodA() @ch16.ex16_05.BugsFixed(value=[112233, 123456])");
        _out.println("  public void ch16.ex16_05.X.methodX() @ch16.ex16_05.BugsFixed(value=[234567, 467211])");
        _out.flush();
        
        Class<?> startClass = Class.forName("ch16.ex16_05.X");

        ClassContents.searchType(startClass);
        ClassContents.showMembers();
        
        cc.getOut().flush();
        System.out.printf(_actual.toString());
        //assertEquals(_expected.toString(), _actual.toString());
    }
    
    @Test
    public void testStrip() {
        assertEquals("HashMap", ClassContents.strip("java.lang.HashMap", "java.lang."));
        assertEquals("  HashMap", ClassContents.strip("  java.lang.HashMap", "java.lang."));
        assertEquals("  ", ClassContents.strip("  java.lang.", "java.lang."));
    }
    
    @Test
    public void testAnnotation() throws Exception {
        Class<?> cls = Class.forName("ch16.ex16_09.X");
        String ret = ClassContents.outputAnnotation(cls);
        
        assertEquals("@ch16.ex16_09.BugsFixed(value=[12, 211])", ret);
    }
}


class A {
    public int num = 123;
    @BugsFixed({"112233","123456"})
    public void methodA(){};
}

@BugsFixed({"12","211"})
class X extends A {
    public int num;
    @BugsFixed({"234567","467211"})
    public void methodX(){};
}


/**
 * P.342
 */
@Retention(RetentionPolicy.RUNTIME)
@interface BugsFixed {
    String[] value();
}


