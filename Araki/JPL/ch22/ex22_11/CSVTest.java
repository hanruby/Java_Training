package ch22.ex22_11;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CSVTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_readCSVTable() throws Exception {
        
        StringReader in = new StringReader(
                "1,2,3, 4\n" +
                "4,3,2,1\n"
        );
        
        List<String[]> actual = CSV.readCSVTable(in);
        
        String[][] expected = {{"1.0","2.0","3.0","4.0",},{"4.0","3.0","2.0","1.0",}};
            
        assertEquals(expected.length, actual.size());
            
        int i = 0;
        for (String[] strings : actual) {
            assertEquals(expected[i].length, strings.length);
            for (int col = 0; col < strings.length; col++) {
                assertEquals(expected[i][col], strings[col]);
            }
            i++;
        }
    } 
}
