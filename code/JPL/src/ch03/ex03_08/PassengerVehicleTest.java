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
	
	@Test
    public void testClone() throws Exception {
		PassengerVehicle fathersCar1 = new PassengerVehicle("Father", 5, 5);
		fathersCar1.setValue(150, 33);

		PassengerVehicle fathersCar2 = fathersCar1.clone();
		PassengerVehicle fathersCar3 = fathersCar1.clone();
		
		assertEquals(fathersCar1.getOwnerName(), fathersCar2.getOwnerName());
		assertEquals(fathersCar1.getId() + 1, fathersCar2.getId());
		assertEquals(fathersCar1.getId() + 2, fathersCar3.getId());
		assertEquals(fathersCar1.getCurrentSpeed(), fathersCar2.getCurrentSpeed());
		assertEquals(fathersCar1.getCurrentDirection(), fathersCar2.getCurrentDirection());
		assertEquals(fathersCar1.getSeatNum(), fathersCar2.getSeatNum());
		assertEquals(fathersCar1.getOccupiedNum(), fathersCar2.getOccupiedNum());
    }

}
