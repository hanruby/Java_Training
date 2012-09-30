package ch22.ex22_09;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CSVTest {

    private CSV csv;
    
    public CSVTest(CSV csv) {
        this.csv = csv;
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { {new CSV_pattern1()} };
        return Arrays.asList(data);
    }
	 
    @Test
    public void test_readCSVTable_4cell() throws Exception {
        File file = new File("JPL/ch22/ex22_07/testdata_4cells.csv");
        
        List<String[]> list = csv.readCSVTable(new FileReader(file), 4);
        
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
        
        List<String[]> list = csv.readCSVTable(new FileReader(file), 3);
        
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
        
        List<String[]> list = csv.readCSVTable(new FileReader(file), 5);
        
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
        
        List<String[]> list = csv.readCSVTable(new FileReader(file), 3);
        
        String[][] expected = {{"1","2","3",},{"3","2","1",}};
        
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
        
        csv.readCSVTable(new FileReader(file), 3);
    }
    
    @Test
    public void test_readCSVTable_Benchmark() throws Exception {
        StringReader in = new StringReader("1,2,3,4\n4,3,2,1\n");
        
        int count = 1000;

        long time = new CSVPatternBenchmark(csv, in, 4).repeat(count);
        
        System.out.println(count + " exec in " + time + " nanoseconds");
    }
}
