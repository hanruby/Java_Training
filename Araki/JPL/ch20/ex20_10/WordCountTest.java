package ch20.ex20_10;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class WordCountTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_Analyze() throws Exception {
        File file = new File("JPL/ch20/ex20_10/WordCount.java");
        
        WordCount wc = new WordCount(file);
        
        wc.analyze();
        
        assertEquals((Integer)4, wc.getCount("file"));
        assertEquals((Integer)4, wc.getCount("file"));
        assertEquals((Integer)0, wc.getCount("hoge"));
    }
}
