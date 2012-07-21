package ch16.Interpret;


import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

public class InterpretTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void test_printObjectField() throws Exception {
        Object obj = Interpret.createObject("ch16.Interpret.TestA");
        
        Interpret.printObjectFields(obj);

        Interpret.setField(obj, "privateBool", "true");
        assertEquals(true, Interpret.getField(obj, "privateBool"));

        Interpret.setField(obj, "privateChar", "b");
        assertEquals('b', Interpret.getField(obj, "privateChar"));

        Interpret.setField(obj, "privateShort", "12");
        assertEquals((short)12, Interpret.getField(obj, "privateShort"));

        Interpret.setField(obj, "privateInt", "13");
        assertEquals(13, Interpret.getField(obj, "privateInt"));

        Interpret.setField(obj, "privateLong", "1234567890");
        assertEquals(1234567890L, Interpret.getField(obj, "privateLong"));

        Interpret.setField(obj, "privateFloat", "13.345");
        assertEquals(13.345f, Interpret.getField(obj, "privateFloat"));

        Interpret.setField(obj, "privateDouble", "56789.678");
        assertEquals(56789.678, Interpret.getField(obj, "privateDouble"));

        Interpret.setField(obj, "privateString", "def");
        assertEquals("def", Interpret.getField(obj, "privateString"));
    }
    
    @Test
    public void test_console() throws Exception {
        
        Interpret.setReader(new BufferedReader(new FileReader("./JPL/ch16/Interpret/console.txt")));
        Interpret.createInterpreter();
    }
}

@SuppressWarnings("unused")
class TestA {
    private boolean privateBool = false;
    private char privateChar = 'a';
    private short privateShort = 10;
    private int privateInt = 10;
    private long privateLong = 10;
    private float privateFloat = 12.34f;
    private double privateDouble = 23.34;
    private String privateString = "abc";
}