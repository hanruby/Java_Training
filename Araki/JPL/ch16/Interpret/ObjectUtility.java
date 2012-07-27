package ch16.Interpret;

import java.lang.reflect.*;

public class ObjectUtility {

    public static Object createObject(String className) {
        Class<?> cls = null;
        Object obj = null;

        // Create new Object
        try {
            cls = (Class<?>)Class.forName(className);
            obj = cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        return obj;
    }

    public static Object createObject(String className, int constructor_number, String argstr) {
        Class<?> cls = null;
        
        try {
            cls = (Class<?>)Class.forName(className);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        Object obj = null;

        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        Constructor<?> constructor = constructors[constructor_number];
        
        String[] values = argstr.split(",");
        Class<?>[] types = (Class<?>[]) constructor.getGenericExceptionTypes(); 
        Object[] objs;
        
        //  Create new Object
        try {
            objs = ObjectUtility.convertObjects(types, values);
            obj = constructor.newInstance(objs);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return obj;
    }
    
    public static Object[] convertObjects(Class<?>[] types, String[] values) throws Exception {
        if (types.length != values.length) {
            throw new IllegalArgumentException("arguments mismatch");
        }
        
        Object[] objs = new Object[types.length];
        
        for (int i = 0; i < types.length; i++) {
            objs[i] = ObjectUtility.convertObject(types[i], values[i]);
        }
        
        return objs;
    }

    public static Object convertObject(Class<?> type, String value) {
        if (type.equals(Boolean.class) || type.equals(boolean.class)) {
            return Boolean.valueOf(value);
        }
        else if (type.equals(Byte.class) || type.equals(byte.class)) {
            return Byte.valueOf(value);
        }
        else if (type.equals(Character.class) || type.equals(char.class)) {
            return value.charAt(0);
        }
        else if (type.equals(Short.class) || type.equals(short.class)) {
            return Short.valueOf(value);
        }
        else if (type.equals(Integer.class) || type.equals(int.class)) {
            return Integer.valueOf(value);
        }
        else if (type.equals(Long.class) || type.equals(long.class)) {
            return Long.valueOf(value);
        }
        else if (type.equals(Float.class) || type.equals(float.class)) {
            return Float.valueOf(value);
        }
        else if (type.equals(Double.class) || type.equals(double.class)) {
            return Double.valueOf(value);
        }
        else if (type.equals(String.class)) {
            return String.valueOf(value);
        }
        else {
            return null;
        }
    }
}
