package ch01.ex01_08;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PointTest {

	Point pointA = new Point();
	Point pointB = new Point();
	
	@Before
	public void setUp() throws Exception{
		pointA.x = 1.0;
		pointA.y = 1.0;
	}
	
	@Test
	public void testInput() {
		pointA.x = 2.0;
		pointA.y = 1.1;
		assertEquals(pointA.x, 2.0, 0);
		assertEquals(pointA.y, 1.1, 0);
	}
	
	@Test
	public void testClear() {
		pointA.clear();
		assertEquals(pointA.x, 0.0, 0);
		assertEquals(pointA.y, 0.0, 0);
	}
	
	@Test
	public void testDistance() {
		pointA.x =  0.0;
		pointA.y = 30.0;
		pointB.x = 40.0;
		pointB.y =  0.0;
		
		double result = pointA.distance(pointB);

		assertEquals(result, 50.0, 0);
		
	}
	
	@Test
	public void testMove() {
		pointA.clear();
		pointA.move(100.0,120.0);

		assertEquals(pointA.x, 100.0, 0);
		assertEquals(pointA.y, 120.0, 0);
	}

	@Test
	public void testPass() {
		pointA.clear();
		pointA.move(100.0,120.0);
		
		pointB.clear();
		pointB.pass(pointA);

		assertEquals(pointB.x, 100.0, 0);
		assertEquals(pointB.y, 120.0, 0);
	}
}
