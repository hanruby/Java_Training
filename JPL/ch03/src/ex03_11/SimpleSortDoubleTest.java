package ex03_11;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SimpleSortDoubleTest {

    @Before
    public void setUp() throws Exception {
    }

    /**
     * P.97 
     * @throws Exception
     */
    @Test
    public void testSort() throws Exception {
        double[] testData = {
            0.3, 1.3e-2, 7.9, 3.17
        };

        double[] expectedData = {
            1.3e-2, 0.3, 3.17, 7.9
        };

        {
            SortDouble bsort = new SimpleSortDouble();
            SortMetrics metrics = bsort.sort(testData);
            System.out.println("Metrics: " + metrics);
            for (int i = 0; i < testData.length; i++) {
                System.out.println("\t" + testData[i]);
            }
        }
        
        for (int i = 0; i < expectedData.length; i++) {
            assertEquals(expectedData[i], testData[i],1.0e-10);
        }
    }
}
