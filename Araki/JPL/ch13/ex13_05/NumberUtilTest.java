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

    @Test
    public void testNumberFormatter_short() {

        assertEquals("1", NumberUtil.numberFormatter("1"));
        assertEquals("12", NumberUtil.numberFormatter("12"));
        assertEquals("123", NumberUtil.numberFormatter("123"));
        assertEquals("1,234", NumberUtil.numberFormatter("1234"));
        assertEquals("12,345", NumberUtil.numberFormatter("12345"));
        assertEquals("123,456", NumberUtil.numberFormatter("123456"));
   }

}
