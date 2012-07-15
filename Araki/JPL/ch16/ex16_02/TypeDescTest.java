package ch16.ex16_02;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TypeDescTest {
    private TypeDesc td = new TypeDesc();

    private ByteArrayOutputStream _actual;
    
    private ByteArrayOutputStream _expected;
    private PrintStream _out;

    @Before
    public void setUp() throws Exception {
        _actual = new ByteArrayOutputStream();
        _expected = new ByteArrayOutputStream();
        
        td.setOut(new PrintStream(new BufferedOutputStream(_actual)));
        _out = new PrintStream(new BufferedOutputStream(_expected));
    }

    @Test
    public void test1() {
        _out.println("nested class ch16.ex16_02.TestClass.NestedClass");
        _out.println("  class ch16.ex16_02.TestClass");
        _out.flush();
        
        Class<?> startClass;
        try {
            startClass = Class.forName("ch16.ex16_02.TestClass$NestedClass");
            td.printType(startClass, 0, TypeDesc.basic);
        
            td.getOut().flush();
            System.out.print(_actual.toString());
            
            assertEquals(_expected.toString(), _actual.toString());

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("Not yet implemented");
        }
    }

    @Test
    public void test2() {
        _out.println("nested interface ch16.ex16_02.TestClass.NestedInterface");
        _out.println("  class ch16.ex16_02.TestClass");
        _out.flush();
        
        Class<?> startClass;
        try {
            startClass = Class.forName("ch16.ex16_02.TestClass$NestedInterface");
            td.printType(startClass, 0, TypeDesc.basic);
        
            td.getOut().flush();
            System.out.print(_actual.toString());
            
            assertEquals(_expected.toString(), _actual.toString());

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail("Not yet implemented");
        }
    }
}


class TestClass {
    public class NestedClass {
    }
    public interface NestedInterface {
    }
}
