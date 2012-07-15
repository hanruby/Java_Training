package ch16.ex16_03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClassContentsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testStrip() {
        assertEquals("HashMap", ClassContents.strip("java.lang.HashMap", "java.lang."));
        assertEquals("  HashMap", ClassContents.strip("  java.lang.HashMap", "java.lang."));
        assertEquals("  ", ClassContents.strip("  java.lang.", "java.lang."));
    }
    
    

}
