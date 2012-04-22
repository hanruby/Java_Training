package ex03_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class XTest {

	private X x;
	
	@Before
	public void setUp() throws Exception {
		x = new X();
	}

	@Test
	public void testX() {
		assertEquals(0x00FF, x.xMask);
	}

	@Test
	public void testMask() {
		assertEquals(0x00AA, x.mask(0xAAAA));
		assertEquals(0x0000, x.mask(0xFF00));
	}

}
