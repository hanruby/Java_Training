import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class VehicleTest {

	@Test
	public void testVehicle() {
		Vehicle v = new Vehicle(100, 90, "hogehoge"); 
		Assert.assertEquals(100, v.getCurrentSpeed());
		Assert.assertEquals(90, v.getCurrentDirection());
		Assert.assertEquals("hogehoge", v.getOwnerName());
	}

}
