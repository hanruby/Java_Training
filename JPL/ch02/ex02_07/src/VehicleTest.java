import static org.junit.Assert.*;
//import junit.framework.Assert;

import org.junit.Test;


public class VehicleTest {

	@Test
	public void testVehicle() {
		Vehicle v = new Vehicle();
		v.setValue(100, 90, "hogehoge");

		assertEquals(100, v.getCurrentSpeed());
		assertEquals(90, v.getCurrentDirection());
		assertEquals("hogehoge", v.getOwnerName());
	}
	
	@Test
	public void testVehicle2() throws Exception {
		Vehicle v = new Vehicle("hogehoge");
		v.setValue(100, 90);

		assertEquals(100, v.getCurrentSpeed());
		assertEquals(90, v.getCurrentDirection());
		assertEquals("hogehoge", v.getOwnerName());
		
	}
}
