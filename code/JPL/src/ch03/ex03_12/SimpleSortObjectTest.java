package ch03.ex03_12;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SimpleSortObjectTest {

    @Before
    public void setUp() throws Exception {
    }

    /**
     * P.97 
     * @throws Exception
     */
    @Test
    public void testSort() throws Exception {
        Object[] testData = {
            0.3, 1.3e-2, 7.9, 3.17, "0.455"
        };

        Object[] expectedData = {
            1.3e-2, 0.3, 0.455, 3.17, 7.9
        };

        {
            SortHarness bsort = new SimpleSortObject();
            SortMetrics metrics = bsort.sort(testData);
            System.out.println("Metrics: " + metrics);
            for (int i = 0; i < testData.length; i++) {
                System.out.println("\t" + testData[i]);
            }
        }
        
        for (int i = 0; i < expectedData.length; i++) {
            assertEquals(expectedData[i].toString(), testData[i].toString());
        }
    }
}
