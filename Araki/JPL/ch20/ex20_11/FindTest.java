package ch20.ex20_11;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class FindTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_find() throws Exception {
        File dir = new File("JPL/ch20/ex20_11/");
        
        Find find = new Find(dir, "java");
     
        String[] files = find.getList();
        for (String file : files) {
            System.out.println(file);
        }
        
        assertEquals("Find.java", files[0]);
        assertEquals("FindTest.java", files[1]);
    }
}
