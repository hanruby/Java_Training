package ch22.ex22_05;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_Dice_between1and6() throws Exception {
        Dice dice = new Dice();
        
        int num;
        for (int i = 0; i < 1000; i++) {
            num = dice.shoot();
            assertTrue( num <= 6);
            assertTrue( num >= 1);
        }
    }
}
