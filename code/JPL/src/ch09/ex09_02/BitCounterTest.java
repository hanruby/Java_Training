package ch09.ex09_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BitCounterTest {

    int[][] testData = {
                        {0xAA, 4},
                        {0xFF, 8},
                        {0x01, 1}, 
                        {0xFEFF, 15}, 
                        {0x3FFFFFFF, 30}, 
                        //{0xFFFFFFFF, 32}, 
                        {1, 1}, 
                       };
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testBitCount() {
        for (int index = 0; index < testData.length; index++) {
            assertEquals(testData[index][1], BitCounter.bitCount(testData[index][0]));
        }
    }

    @Test
    public void testBitCount2() {
        for (int index = 0; index < testData.length; index++) {
            assertEquals(testData[index][1], BitCounter.bitCount2(testData[index][0]));
        }
    }

    @Test
    public void testBitCount3() {
        for (int index = 0; index < testData.length; index++) {
            assertEquals(testData[index][1], BitCounter.bitCount3(testData[index][0]));
        }
    }

    @Test
    public void testBitCount4() {
        for (int index = 0; index < testData.length; index++) {
            assertEquals(testData[index][1], BitCounter.bitCount4(testData[index][0]));
        }
    }

}
