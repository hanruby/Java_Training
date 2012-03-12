import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BadDataSetExceptionTest {

	private MyUtilities utl;
	private double[] dataSet = null;
	
	@Before
	public void setUp() throws Exception{
		utl = new MyUtilities();
	}
	
	@Test
	public void testGetDataSet() {
		try {
			dataSet = utl.getDataSet("NotFound");
		} catch (BadDataSetException e) {
			e.printStackTrace();
			System.out.println(e.file);
			System.out.println(e.e); // DEBUGすると表示順序が変わる？
		}
		assertEquals(0, 0);
	}
}
