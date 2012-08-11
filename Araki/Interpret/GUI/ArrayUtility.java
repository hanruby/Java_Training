package GUI;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ArrayUtility {
    
    public static <T> T[] createArrayObject(Class<T> type, int size) {

        @SuppressWarnings("unchecked") // P.378 : Array.newInstance is an exception.
        T[] arr = (T[]) Array.newInstance(type, size);
        
        return arr;
    }

    public static void initArray(Object array, Constructor<?> constructor, Object... initargs) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        if (array == null) {
            return;
        }

        int length = Array.getLength(array);

        if ( getDim(array) >= 2 ) {
            for (int i = 0; i < length; i++) {
                initArray(Array.get(array, i), constructor, initargs);
            }
        }
        else {
            for (int i = 0; i < length; i++) {
                Array.set(array, i, constructor.newInstance(initargs));
            }
        }
    }
    
    public static void setArrayContents(Object array, String contents) {

        String[] values = contents.split(",");
        
        if ( Array.getLength(array) != values.length ) {
            throw new ArrayIndexOutOfBoundsException("Size mismatch");
        }
        
        if ( array.getClass().isArray() ) {
            
            for (int i = 0; i < values.length; i++) {
                Array.getLength(array);
                Array.set(array, i, ObjectUtility.convertObject(array.getClass().getComponentType(), values[i]));
            }
        }
    }
    
    public static void showArrayContntes(Object array) {
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            System.out.println(Array.get(array, i));        
        }
    }
    
    public static int getDim(Object array) {
        int dim = 0;

        Class<?> cls = array.getClass();

        while (cls.isArray()) {
            dim++;
            cls = cls.getComponentType();
        }
        
        return dim;
    }
    
    public static int[] parseDimensionString(String str) {
        String[] strs = str.split("x");
        int[] values = new int[strs.length];
        
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.valueOf(strs[i]);
        }
        return values;
    }
}
