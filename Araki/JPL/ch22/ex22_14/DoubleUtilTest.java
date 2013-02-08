package ch22.ex22_14;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoubleUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    
    @Test
    public void testSum() throws Exception {
        String doubleString = "10.2 11.8 8.0 1";
        
        double actual = DoubleUtil.sum(doubleString);
        
        assertEquals(31, actual, 0.001);
    }
}
