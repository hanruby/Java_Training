package ch09.ex09_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BitCounterTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testBitCount() {
        assertEquals(4, BitCounter.bitCount(0xAA));
        assertEquals(8, BitCounter.bitCount(0xFF));
        assertEquals(1, BitCounter.bitCount(0x01));
        assertEquals(15, BitCounter.bitCount(0xFEFF));
        assertEquals(32, BitCounter.bitCount(-1));
        assertEquals(1, BitCounter.bitCount(1));
    }

}
