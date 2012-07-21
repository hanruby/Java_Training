package ch16.Interpret;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

public class InterpretTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void test_console() throws Exception {
        Interpret interpreter = new Interpret();
        interpreter.setReader(new BufferedReader(new FileReader("./JPL/ch16/Interpret/console.txt")));
        interpreter.createInterpreter();
    }
}
