package ch13.ex13_01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CharCounterTest {

    int result;
    
    @Before
    public void setUp() throws Exception {
        result = 0;
    }

    @Test
    public void testCountChar() {
        
        result = CharCounter.countChar("aaaa",'a');
        assertEquals(4, result);
    }

}
