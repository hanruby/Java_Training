package ch13.ex13_04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ObjectCreaterTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testParse() {

        ArrayList<Object> expectedResult = new ArrayList<Object>();
        expectedResult.add(new Boolean(true));
        expectedResult.add(new Byte((byte) 34));
        expectedResult.add(new Character('a'));
        expectedResult.add(new Short((short) 98));
        expectedResult.add(new Integer(1234));
        expectedResult.add(new Long(4567));
        expectedResult.add(new Float(20.345));
        expectedResult.add(new Double(3456.56));

        String testData = 
            "Boolean true\n" +
            "Byte 34\n" +
            "Character a\n" +
            "Short 98\n" +
            "Integer 1234\n" +
            "Long 4567\n" +
            "Float 20.345\n" +
            "Double 3456.56";
        
        List<Object> result = ObjectCreater.parse(testData);
        
        assertTrue(result != null);

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i), result.get(i));
        }
    }
    
    @Test(expected = NullPointerException.class)
    public void testNoData() throws Exception {

        ObjectCreater.parse(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalData() throws Exception {

        ObjectCreater.parse("hoge\n");
    }
    
    @Test(expected = NumberFormatException.class)
    public void testIllegalNum() throws Exception {

        ObjectCreater.parse("Double 2345lfdg\n");
    }

}
