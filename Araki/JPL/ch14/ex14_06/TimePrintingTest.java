package ch14.ex14_06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimePrintingTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testTimePrinting() {
    
        TimePrinting timer = new TimePrinting();
        
        timer.addInterval(15);
        timer.addInterval(7);

        while( timer.getElapse() < 22 ) { 
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }        

    }

}
