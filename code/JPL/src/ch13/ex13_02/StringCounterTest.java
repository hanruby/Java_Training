package ch13.ex13_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCounterTest {

    int result;
    
    @Before
    public void setUp() throws Exception {
        result = 0;
    }

    @Test
    public void testCountChar_1() {
        
        result = StringCounter.countStr("aaaa","a");
        assertEquals(4, result);
        
    }

    @Test
    public void testCountChar_2() {
        
        result = StringCounter.countStr("abc","a");
        assertEquals(1, result);
        
    }

    @Test
    public void testCountChar_3() {

        result = StringCounter.countStr("abcdefgabcdefgabcdefg","a");
        assertEquals(3, result);
        
    }

    @Test
    public void testCountChar_4() {

        result = StringCounter.countStr("abcdefgabcdefgabcdefg","g");
        assertEquals(3, result);
    }

    @Test
    public void testCountStr_1() {

        result = StringCounter.countStr("aaaa","aa");
        assertEquals(3, result);
    }

    @Test
    public void testCountStr_2() {

        result = StringCounter.countStr("abcabcabee","abc");
        assertEquals(2, result);
    }

    @Test
    public void testCountStr_3() {

        result = StringCounter.countStr("abcabcabee","bc");
        assertEquals(2, result);
    }

    @Test
    public void testCountStr_4() {

        result = StringCounter.countStr("abcabcabee","ee");
        assertEquals(1, result);
    }

    @Test(expected = NullPointerException.class)
    public void testCountChar_Exception_1() {
        
        result = StringCounter.countStr("abc", null);
    }

    @Test(expected = NullPointerException.class)
    public void testCountChar_Exception_2() {
        
        result = StringCounter.countStr(null,"a");
    }
}
