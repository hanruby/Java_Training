package ch22.ex22_02;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhichCharsTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    /**
     * Verify that characters occurred is marked in a string.
     */
    public void test_charactersMarked() throws Exception {
        {
            WhichChars wc = new WhichChars("Testing 1 2 3");
            
            assertEquals("[ 123Teginst]", wc.toString());
        }
        {
            WhichChars wc = new WhichChars("Testing 1 2 3 123123321test");
            
            assertEquals("[ 123Teginst]", wc.toString());
        }
        {
            WhichChars wc = new WhichChars("123１２３あいうあいう");
            
            assertEquals("[123あいう１２３]", wc.toString());
        }
    }

}