package ch22.ex22_06;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GaussianTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testScoreSum() throws Exception {
        Gaussian g = new Gaussian();
        g.run();
        double[] data = g.getData();
        double sum = 0.0;
        
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        
        assertEquals(1.0, sum, 0.01);
        
    }
}
