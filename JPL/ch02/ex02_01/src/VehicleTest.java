import static org.junit.Assert.*;
//import junit.framework.Assert;

import org.junit.Test;


public class VehicleTest {

	@Test
	public void testVehicle() {
		Vehicle v = new Vehicle(100, 90, "hogehoge"); 

		assertEquals(100, v.getCurrentSpeed());
		assertEquals(90, v.getCurrentDirection());
		assertEquals("hogehoge", v.getOwnerName());
	}

}
