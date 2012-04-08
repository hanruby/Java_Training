package ex03_03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class YTest {
	private Y y;

	@Before
	public void setUp() throws Exception {
		y = new Y();
	}

	@Test
	public void testY() {
		assertEquals(0xFF00, y.yMask);
		assertEquals(0xFFFF, y.fullMask);
	}

	@Test
	public void testMask() {
		assertEquals(0x0101, y.mask(0x0101));
		assertEquals(0xAAAA, y.mask(0xAAAA));
	}

}
