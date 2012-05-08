package ch03.ex03_06;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerVehicleTest {

	@Test
	public void testPassengerVehicle() {
		PassengerVehicle v = new PassengerVehicle("Father", 4, 3);
		
		assertEquals(4, v.getSeatNum());
		assertEquals(3, v.getOccupiedNum());
	}

}
