package ch14.ex14_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrintServerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPrint() {
        PrintServer server = new PrintServer();

        for (int i = 0; i < 100; i++) {
            server.print(new PrintJob("job no." + i));
        }
    }
}
