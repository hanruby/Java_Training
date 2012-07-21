package ch16.Interpret;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldUtilityTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_printObjectField() throws Exception {
        Object obj = ObjectUtility.createObject("ch16.Interpret.TestA");
        
        FieldUtility.printObjectFields(obj);

        FieldUtility.setField(obj, "privateBool", "true");
        assertEquals(true, FieldUtility.getField(obj, "privateBool"));

        FieldUtility.setField(obj, "privateChar", "b");
        assertEquals('b', FieldUtility.getField(obj, "privateChar"));

        FieldUtility.setField(obj, "privateShort", "12");
        assertEquals((short)12, FieldUtility.getField(obj, "privateShort"));

        FieldUtility.setField(obj, "privateInt", "13");
        assertEquals(13, FieldUtility.getField(obj, "privateInt"));

        FieldUtility.setField(obj, "privateLong", "1234567890");
        assertEquals(1234567890L, FieldUtility.getField(obj, "privateLong"));

        FieldUtility.setField(obj, "privateFloat", "13.345");
        assertEquals(13.345f, FieldUtility.getField(obj, "privateFloat"));

        FieldUtility.setField(obj, "privateDouble", "56789.678");
        assertEquals(56789.678, FieldUtility.getField(obj, "privateDouble"));

        FieldUtility.setField(obj, "privateString", "def");
        assertEquals("def", FieldUtility.getField(obj, "privateString"));
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
