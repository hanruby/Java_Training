package ch03.ex03_09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch03.ex03_08.Vehicle;

public class GarageTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGarage() {
        Garage g = new Garage(new Vehicle[]{ new Vehicle("Father"), new Vehicle("me")});
        
        Vehicle[] vehicles = g.getVehicles();
        assertEquals(vehicles[0].getOwnerName(), "Father");
        assertEquals(vehicles[1].getOwnerName(), "me");
    }

    @SuppressWarnings("unused")
    @Test
    public void testGarageArgNull() {
        try {
            Garage g1 = new Garage((Vehicle[])null);
            fail("should be throw exception");
        } catch (IllegalArgumentException e) {}

        try {
            Garage g2 = new Garage(null);
            fail("should be throw exception");
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testGetVehicles() {
        Vehicle[] vs = new Vehicle[]{ new Vehicle("Father"), new Vehicle("me") };
        Garage g = new Garage(vs);
        
        Vehicle[] res = g.getVehicles();
        assertEquals(res[0].getOwnerName(), vs[0].getOwnerName());
        assertEquals(res[0].getId(), vs[0].getId());

        assertEquals(res[1].getOwnerName(), vs[1].getOwnerName());
        assertEquals(res[1].getId(), vs[1].getId());
    }

    @Test
    public void testClone() {
        Vehicle[] vs = new Vehicle[]{ new Vehicle("Father"), new Vehicle("me") };
        Garage g1 = new Garage(vs);
        Garage g2 = g1.clone();

        assertEquals(g1.getVehicles()[0].getOwnerName(), g2.getVehicles()[0].getOwnerName());
        assertEquals(g1.getVehicles()[0].getId() + 2, g2.getVehicles()[0].getId());

    }

}
