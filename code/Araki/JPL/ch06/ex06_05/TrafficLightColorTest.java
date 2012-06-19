package ch06.ex06_05;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class TrafficLightColorTest {

    TrafficLightColor signal;
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetColor() {
        signal = TrafficLightColor.RED;
        assertEquals(Color.RED, signal.getColor());

        signal = TrafficLightColor.YELLOW;
        assertEquals(Color.YELLOW, signal.getColor());

        signal = TrafficLightColor.GREEN;
        assertEquals(Color.GREEN, signal.getColor());
    }
}
