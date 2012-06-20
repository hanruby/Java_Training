package ch13.ex13_06;

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
    public void testNumberFormatter3() {
        String resultStr = NumberUtil.numberFormatter("1543729", 3, ",");
        
        assertEquals(resultStr, "1,543,729");

        assertTrue(resultStr.equals("1,543,729"));
    }

    @Test
    public void testNumberFormatter4() {
        String resultStr = NumberUtil.numberFormatter("23984573201948018256361539801256361539", 3, ",");
        
        assertEquals(resultStr, "23,984,573,201,948,018,256,361,539,801,256,361,539");

        assertTrue(resultStr.equals("23,984,573,201,948,018,256,361,539,801,256,361,539"));
    }

    @Test
    public void testNumberFormatter5() {
        String resultStr = NumberUtil.numberFormatter("23984573201948018256361539801256361539", 5, "/");
        
        assertEquals(resultStr, "239/84573/20194/80182/56361/53980/12563/61539");

        assertTrue(resultStr.equals("239/84573/20194/80182/56361/53980/12563/61539"));
    }

}
