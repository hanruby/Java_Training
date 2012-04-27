package ch06.ex06_02;

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
	
	@Test
	public void testChangeSpeed() throws Exception {
		Vehicle v = new Vehicle("hogehoge");
		v.setCurrentSpeed(150);
		v.changeSpeed(120);
		
		assertEquals(120, v.getCurrentSpeed());
	}
	
	@Test
	public void tesetStop() throws Exception {
		Vehicle v = new Vehicle("hogehoge");
		v.setCurrentSpeed(150);
		v.stop();
		
		assertEquals(0, v.getCurrentSpeed());
	}
	
	@Test
	public void testTurn() throws Exception {
		Vehicle v = new Vehicle(150,300,"turncar");
		boolean result;
		
		result = v.turn(Vehicle.Turn.TURN_LEFT);
		assertEquals(true, result);
		assertEquals(210, v.getCurrentDirection());

		result = v.turn(Vehicle.Turn.TURN_RIGHT);
		assertEquals(true, result);
		assertEquals(300, v.getCurrentDirection());

		result = v.turn(-30);
		assertEquals(true, result);
		assertEquals(270, v.getCurrentDirection());
	}
}
