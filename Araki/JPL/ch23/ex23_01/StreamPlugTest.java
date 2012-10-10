package ch23.ex23_01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StreamPlugTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAddProgram() throws Exception {
        Process proc = StreamPlug.userProg("ping -c 5 8.8.8.8");

        assertEquals(proc.waitFor(), 0);
    }
}
