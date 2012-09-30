package ch22.ex22_07;


import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CSVTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_readCSVTable() throws Exception {
        File file = new File("JPL/ch22/ex22_07/testdata.csv");
        
        List<String[]> list = CSV.readCSVTable(new FileReader(file));
        
        String[][] expected = {{"1","2","3","4",},{"4","3","2","1",}};
        
        int i = 0;
        for (String[] strings : list) {
            for (int col = 0; col < strings.length; col++) {
                assertEquals(expected[i][col], strings[col]);
            }
            i++;
        }
    }

    @Test
    public void test_readCSVTable_3cell() throws Exception {
        File file = new File("JPL/ch22/ex22_07/testdata.csv");
        
        List<String[]> list = CSV.readCSVTable(new FileReader(file), 3);
        
        String[][] expected = {{"1","2","3",},{"4","3","2",}};
        
        int i = 0;
        for (String[] strings : list) {
            for (int col = 0; col < strings.length; col++) {
                assertEquals(expected[i][col], strings[col]);
            }
            i++;
        }
    }
}
