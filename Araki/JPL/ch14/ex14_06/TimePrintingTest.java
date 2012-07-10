package ch14.ex14_06;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimePrintingTest {
    private PrintStream _saved;
    private ByteArrayOutputStream _actual;
    private ByteArrayOutputStream _expected;
    private PrintStream _out;
    
    @Before
    public void setUp() throws Exception {
        _saved = System.out;
        _actual = new ByteArrayOutputStream();
        _expected = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(_actual)));
        _out = new PrintStream(new BufferedOutputStream(_expected));
    }
    
    @After
    public void tearDown() {
        System.setOut(_saved);
    }

    @Test
    public void testTimePrinting() {
        // Expected
        _out.println("Elapse : 1 sec");
        _out.println("Elapse : 2 sec");
        _out.println("Elapse : 3 sec");
        _out.println("Elapse : 4 sec");
        _out.println("Elapse : 5 sec");
        _out.println("Elapse : 6 sec");
        _out.println("Elapse : 7 sec");
        _out.println("Interval : 7");
        _out.println("Elapse : 8 sec");
        _out.println("Elapse : 9 sec");
        _out.println("Elapse : 10 sec");
        _out.println("Elapse : 11 sec");
        _out.println("Elapse : 12 sec");
        _out.println("Elapse : 13 sec");
        _out.println("Elapse : 14 sec");
        _out.println("Interval : 7");
        _out.println("Elapse : 15 sec");
        _out.println("Interval : 15");
        _out.println("Elapse : 16 sec");
        _out.println("Elapse : 17 sec");
        _out.println("Elapse : 18 sec");
        _out.println("Elapse : 19 sec");
        _out.println("Elapse : 20 sec");
        _out.println("Elapse : 21 sec");
        _out.println("Interval : 7");
        _out.println("Elapse : 22 sec");

        _out.flush();
        
        // Test
        TimePrinting timer = new TimePrinting();
        
        timer.addInterval(15);
        timer.addInterval(7);

        // wait
        while( timer.getElapse() < 22 ) { 
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }      
        
        // Compare
        System.out.flush();
        assertEquals(_expected.toString(), _actual.toString());

    }

}
