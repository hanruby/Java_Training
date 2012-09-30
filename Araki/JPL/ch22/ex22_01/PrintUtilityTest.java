package ch22.ex22_01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unused")
public class PrintUtilityTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPrintDoubleArray_001() throws Exception {
        Double[] doubleTable = new Double[]{
                22.42,
                523.5,
                52233.324355,
                3.5,
                355.621266,
                2523.5,
                534.3355,
                23.5,
                55.656,
                25.5,
                43.5,
                3.652,
                225.235,
                5.55,
                90.5,
                509.66,
                25.5,
                -0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001,
                53.355,
                3.546,
                215.65266,
                0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001,
                53.355,
                0.00003259238500000000000000090808000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001,
                3.546,
                215.65266,
                };

        for (int i = 1; i < 12; i++) {
            String result = PrintUtility.FormatDoubleArray(doubleTable, i);
            System.out.println(result);
        }
    }
    
    @Test(expected = NullPointerException.class)
    public void test_FormatDoubleArray_NullPointerException() throws Exception {
        PrintUtility.FormatDoubleArray(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FormatDoubleArray_IllegalArgumentException() throws Exception {
        PrintUtility.FormatDoubleArray(new Double[]{22.2}, 0);
    }
}
