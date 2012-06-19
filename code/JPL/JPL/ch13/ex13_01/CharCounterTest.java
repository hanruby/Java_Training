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
    public void testCountChar_1() {
        
        result = CharCounter.countChar("aaaa",'a');
        assertEquals(4, result);
        
    }

    @Test
    public void testCountChar_2() {
        
        result = CharCounter.countChar("abc",'a');
        assertEquals(1, result);
        
    }

    @Test
    public void testCountChar_3() {

        result = CharCounter.countChar("abcdefgabcdefgabcdefg",'a');
        assertEquals(3, result);
        
    }

    @Test
    public void testCountChar_4() {

        result = CharCounter.countChar("abcdefgabcdefgabcdefg",'g');
        assertEquals(3, result);
    }

    @Test(expected = NullPointerException.class)
    public void testCountChar_Exception_1() {
        
        result = CharCounter.countChar("abc",(Character) null);
    }

    @Test(expected = NullPointerException.class)
    public void testCountChar_Exception_2() {
        
        result = CharCounter.countChar(null,'a');
    }
}
