import static org.junit.Assert.*;
//import junit.framework.Assert;

import org.junit.Test;


public class VehicleTest {

	@Test
	public void testVehicleInit() {
		Vehicle v = new Vehicle();

		assertEquals(0, v.getCurrentSpeed());
		assertEquals(0, v.getCurrentDirection());
		assertEquals("none", v.getOwnerName());
		assertEquals(1, v.getId());
	}
	
	@Test
	public void testVehicle() {
		Vehicle v = new Vehicle();
		v.setValue(100, 90, "hogehoge");

		assertEquals(100, v.getCurrentSpeed());
		assertEquals(90, v.getCurrentDirection());
		assertEquals("hogehoge", v.getOwnerName());
		assertEquals(2, v.getId());
	}
	
	@Test
	public void testVehicle2() throws Exception {
		Vehicle v = new Vehicle("hogehoge");
		v.setValue(100, 90);

		assertEquals(100, v.getCurrentSpeed());
		assertEquals(90, v.getCurrentDirection());
		assertEquals("hogehoge", v.getOwnerName());
		assertEquals(3, v.getId());
	}
	
	@Test
	public void testGetId() throws Exception {
		long max = Vehicle.getMaxId();
		assertEquals(3, max);
	}
}
