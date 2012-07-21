package ch16.Interpret;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ObjectUtilityTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_printObjectField() throws Exception {
        Object obj = ObjectUtility.createObject("ch16.Interpret.TestA");
        
        ObjectUtility.printObjectFields(obj);

        ObjectUtility.setField(obj, "privateBool", "true");
        assertEquals(true, ObjectUtility.getField(obj, "privateBool"));

        ObjectUtility.setField(obj, "privateChar", "b");
        assertEquals('b', ObjectUtility.getField(obj, "privateChar"));

        ObjectUtility.setField(obj, "privateShort", "12");
        assertEquals((short)12, ObjectUtility.getField(obj, "privateShort"));

        ObjectUtility.setField(obj, "privateInt", "13");
        assertEquals(13, ObjectUtility.getField(obj, "privateInt"));

        ObjectUtility.setField(obj, "privateLong", "1234567890");
        assertEquals(1234567890L, ObjectUtility.getField(obj, "privateLong"));

        ObjectUtility.setField(obj, "privateFloat", "13.345");
        assertEquals(13.345f, ObjectUtility.getField(obj, "privateFloat"));

        ObjectUtility.setField(obj, "privateDouble", "56789.678");
        assertEquals(56789.678, ObjectUtility.getField(obj, "privateDouble"));

        ObjectUtility.setField(obj, "privateString", "def");
        assertEquals("def", ObjectUtility.getField(obj, "privateString"));
    }
}


@SuppressWarnings("unused")
class TestA {
    private boolean privateBool = false;
    private char privateChar = 'a';
    private short privateShort = 10;
    private int privateInt = 10;
    private long privateLong = 10;
    private float privateFloat = 12.34f;
    private double privateDouble = 23.34;
    private String privateString = "abc";
}
