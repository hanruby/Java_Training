package GUI;


import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.Before;
import org.junit.Test;

public class ArrayUtilityTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testGetArrayDim() throws Exception {
        Object obj;
 
        obj = Array.newInstance(Object.class, 100);
        assertEquals(1, ArrayUtility.getDim(obj));
        
        obj = Array.newInstance(Object.class, new int[]{40});
        assertEquals(1, ArrayUtility.getDim(obj));
        
        obj = Array.newInstance(Object.class, new int[]{4,4});
        assertEquals(2, ArrayUtility.getDim(obj));
        
        obj = Array.newInstance(Object.class, new int[]{4,4,5});
        assertEquals(3, ArrayUtility.getDim(obj));

        obj = Array.newInstance(Object.class, new int[]{4,4,5,2,4,2,5,12,1,4,32});
        assertEquals(11, ArrayUtility.getDim(obj));

    }
    
    @Test
    public void createArr() throws Exception {
        //assertEquals(1, ArrayUtility.getDim(ArrayUtility.createArrayObject(Object.class, 23)));
    }
    
    @Test
    public void testSetArr() throws Exception {
        Object array = Array.newInstance(Float.class, 4);
        assertEquals(1, ArrayUtility.getDim(array));
        ArrayUtility.setArrayContents(array, "12.2f,22.22f,1.1f,4.2f");
        //ArrayUtility.showArrayContntes(array);
        
        assertEquals(12.2f, Array.get(array, 0));
        assertEquals(4.2f, Array.get(array, 3));
    }
    
    @Test
    public void testPerser() throws Exception {
        {
            int[] result = ArrayUtility.parseDimensionString("1x2x3x4");
            int[] expected = {1,2,3,4};

            for (int i = 0; i < expected.length; i++) {
                assertEquals(expected[i], result[i]);
            }
        }
        {
            int[] result = ArrayUtility.parseDimensionString("1x2x3x");
            int[] expected = {1,2,3};

            for (int i = 0; i < expected.length; i++) {
                assertEquals(expected[i], result[i]);
            }
        }
    }
    
    @Test
    public void testInitArray() throws Exception {
        {
            Object array = Array.newInstance(Integer.class, new int[]{3});
            //System.out.println(Integer.class.getDeclaredConstructors()[0]);
            ArrayUtility.initArray(array, Integer.class.getDeclaredConstructors()[0], 0);

            int length = Array.getLength(array);
            for (int i = 0; i < length; i++) {
                assertEquals(0, Array.get(array,i));
            }
        }
        {
            Object array = Array.newInstance(Float.class, new int[]{3,5});
            //System.out.println(Float.class.getDeclaredConstructors()[0]);
            ArrayUtility.initArray(array, Float.class.getDeclaredConstructors()[0], 0.0f);

            int length1 = Array.getLength(array);
            for (int i = 0; i < length1; i++) {
                Object arr = Array.get(array,i);
                int length2 = Array.getLength(arr);
                for (int j = 0; j < length2; j++) {
                    assertEquals(0.0f, Array.get(arr,j));
                }
            }
        }
    }
    
    @Test
    public void testCastArray() throws Exception {
        String[] array = {"aaa", "bbb"};
        Object[] objarr = ArrayUtility.castArray(array);

        assertEquals(objarr[0].toString(), array[0]);
        assertEquals(objarr[1].toString(), array[1]);
    }
    
}
