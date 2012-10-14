package ch24.ex24_03;

import org.junit.Before;
import org.junit.Test;

public class DateStylesTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_showDate() throws Exception {
        DateStyles.showDate("Friday, August 29, 1986 5:00:00 PM EDT");
        DateStyles.showDate("August 29, 1986 5:00:00 PM EDT");
        DateStyles.showDate("Aug 29, 1986 5:00:00 PM");
        DateStyles.showDate("8/29/86 5:00 PM");
    }
}
