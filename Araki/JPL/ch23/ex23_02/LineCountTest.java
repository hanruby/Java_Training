package ch23.ex23_02;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LineCountTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testUsage() throws Exception {
        LineCount.main(new String[]{});
    }

    @Test
    public void testMain() throws Exception {
        LineCount.main(new String[]{"cat","JPL/ch23/ex23_02/LineCount.java"});
    }

    @Test
    public void test_method_execCommand() throws Exception {
        String[] lines = LineCount.execCommand(new String[]{"ls","JPL/ch23/ex23_02"});
        
        assertEquals("LineCount.java", lines[0]);
        assertEquals("LineCountTest.java", lines[1]);
        assertEquals("README.md", lines[2]);
    }

}
