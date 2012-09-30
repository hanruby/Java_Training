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
        
        for (String[] strings : list) {
            for (String string : strings) {
                System.out.printf("%s ",string);
            }
            System.out.printf("%n");
        }
    }
}
