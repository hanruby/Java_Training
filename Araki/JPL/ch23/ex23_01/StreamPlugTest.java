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

    @Test
    public void testAddPrograms() throws Exception {
        Process ping1 = StreamPlug.userProg("ping -c 3 8.8.8.8");
        Process ping2 = StreamPlug.userProg("ping -c 3 localhost");

        assertEquals(ping1.waitFor(), 0);
        assertEquals(ping2.waitFor(), 0);
    }
}
