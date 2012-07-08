package ch14.ex14_03;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAdder() throws Exception {
        final Adder adder = new Adder();

        // Create some threads 
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        adder.add(1);
                    }
                }
            }).start();
        }
        
        // 10 threads x 100 times = 1000
        assertEquals(1000, adder.getNum());
    }
}
