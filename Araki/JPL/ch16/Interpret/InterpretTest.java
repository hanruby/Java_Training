package ch16.Interpret;


import static org.junit.Assert.*;

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
        Interpret.setField(obj, "privateVal", 13);
        
        assertEquals(13, Interpret.getField(obj, "privateVal"));
    }
}

@SuppressWarnings("unused")
class TestA {
    private int privateVal = 10;
    private int privateConstVal = 12;
}