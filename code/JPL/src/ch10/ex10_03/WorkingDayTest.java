package ch10.ex10_03;

import ch06.ex06_01.DayOfWeek;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class WorkingDayTest {

    @SuppressWarnings("serial")
    final HashMap<DayOfWeek, Boolean> testData = new HashMap<DayOfWeek, Boolean>() {{
        put (DayOfWeek.SUNDAY    , false);
        put (DayOfWeek.SATURDAY  , false);
        put (DayOfWeek.MONDAY    , true); 
        put (DayOfWeek.TUESEDAY  , true); 
        put (DayOfWeek.WEDNESDAY , true); 
        put (DayOfWeek.THURSDAY  , true); 
        put (DayOfWeek.FRIDAY    , true); 
    }};
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testWorkingDay() throws Exception {
        for(DayOfWeek w : testData.keySet()) {
            assertEquals(testData.get(w), WorkingDay.isWorkingDay_usingIf(w));
            assertEquals(testData.get(w), WorkingDay.isWorkingDay_usingSwitch(w));
        }
    }
}
