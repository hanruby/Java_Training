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
        // テストする各オブジェクトをここに追加する
        Object[][] data = new Object[][] { 
                {new CSV_pattern1()},
                {new CSV_pattern2()},
                {new CSV_pattern3()},
                {new CSV_pattern4()},
                };
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

        System.out.println(csv.getClass());
        int count = 1000;
        {
            StringReader in = new StringReader(
                    "1,2,3,4\n" +
                    "4,3,2,1\n"
            );

            long time = new CSVPatternBenchmark(csv, in, 4).repeat(count);
            System.out.println(
                    "\tshort pattern : " + csv.createPattern(4) + 
                    "\n \t " + time + " nanoseconds");
        }
        {
            StringReader in = new StringReader(
                    "12345678909876543213456,78909876543,211112345678,90987654321234567,890987654321,123456789,098765432123456789098765,43213456789098767y6543212345,67890987654321,23,45678976543213456,756787654323,4567890809876,54343432,1234\n" +
                    "123456789098765432134567,890987654,32111123456789,098765432123456,7890987654321,1234567890,9876543212345678909876,543213456789098767y65432123456,7890987654321,2,3456789765432134567,5678765432,345678908098765,4343432,1234\n"
            );

            long time = new CSVPatternBenchmark(csv, in, 15).repeat(count);
            System.out.println(
                    "\tlong pattern : " + csv.createPattern(15) + 
                    "\n \t " + time + " nanoseconds");
        }
        System.out.println();
    }
}
