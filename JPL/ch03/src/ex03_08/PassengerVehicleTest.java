package ex03_08;

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
