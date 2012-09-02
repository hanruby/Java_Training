package ch20.ex20_05;


import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GrepTest {

    private PrintStream _saved;
    private ByteArrayOutputStream _actual;
    private ByteArrayOutputStream _expected;
    private PrintStream _out;
    
    @Before
    public void setUp() throws Exception {
        _saved = System.out;
        _actual = new ByteArrayOutputStream();
        _expected = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(_actual)));
        _out = new PrintStream(new BufferedOutputStream(_expected));
    }

    @After
    public void tearDown() {
        System.setOut(_saved);
    }

    @Test
    public void test_findString_01() throws Exception {
        // Expected
        _out.println("4:hoge");
        _out.println("7:hoge");
        _out.println("12:hoge");
        _out.flush();
        
        // Test
        Grep.findString("JPL/ch20/ex20_05/testfile.txt", "hoge");
        
        // Compare
        System.out.flush();
        assertEquals(_expected.toString(), _actual.toString());
    }

    @Test
    public void test_findString_02() throws Exception {
        // Expected
        _out.println("6:lll");
        _out.println("13:lll");
        _out.println("14:llll");
        _out.println("15:ll");
        _out.flush();
        
        // Test
        Grep.findString("JPL/ch20/ex20_05/testfile.txt", "ll");
        
        // Compare
        System.out.flush();
        assertEquals(_expected.toString(), _actual.toString());
        
    }

}
