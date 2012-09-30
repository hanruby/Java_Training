package ch22.ex22_08;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CSVTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_readCSVTable_4cell() throws Exception {
        File file = new File("JPL/ch22/ex22_07/testdata_4cells.csv");
        
        List<String[]> list = CSV.readCSVTable(new FileReader(file), 4);
        
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
        File file = new File("JPL/ch22/ex22_07/testdata_3cells.csv");
        
        List<String[]> list = CSV.readCSVTable(new FileReader(file), 3);
        
        String[][] expected = {{"1","2","3",},{"3","2","1",}};
        
        int i = 0;
        for (String[] strings : list) {
            for (int col = 0; col < strings.length; col++) {
                assertEquals(expected[i][col], strings[col]);
            }
            i++;
        }
    }

    @Test
    public void test_readCSVTable_5cell() throws Exception {
        File file = new File("JPL/ch22/ex22_07/testdata_5cells.csv");
        
        List<String[]> list = CSV.readCSVTable(new FileReader(file), 5);
        
        String[][] expected = {{"1","2","3","4","5"},{"5","4","3","2","1"}};
        
        int i = 0;
        for (String[] strings : list) {
            for (int col = 0; col < strings.length; col++) {
                assertEquals(expected[i][col], strings[col]);
            }
            i++;
        }
    }
    
    @Test
    public void test_readCSVTable_emptyline() throws Exception {
        File file = new File("JPL/ch22/ex22_08/test_emptyline.csv");
        
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
    
    @Test(expected=IOException.class)
    public void test_readCSVTable_wrong_cell() throws Exception {
        File file = new File("JPL/ch22/ex22_07/testdata_4cells.csv");
        
        CSV.readCSVTable(new FileReader(file), 3);
    }
}
