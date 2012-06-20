package ch13.ex13_05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumberUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testNumberFormatter1() {
        String resultStr = NumberUtil.numberFormatter("1543729");
        
        assertEquals(resultStr, "1,543,729");

        assertTrue(resultStr.equals("1,543,729"));
    }

    @Test
    public void testNumberFormatter2() {
        String resultStr = NumberUtil.numberFormatter("23984573201948018256361539801256361539");
        
        assertEquals(resultStr, "23,984,573,201,948,018,256,361,539,801,256,361,539");

        assertTrue(resultStr.equals("23,984,573,201,948,018,256,361,539,801,256,361,539"));
    }

}