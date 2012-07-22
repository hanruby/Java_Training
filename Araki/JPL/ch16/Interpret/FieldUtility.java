package ch16.Interpret;

import java.lang.reflect.*;

public class FieldUtility {

    public static Object getField(Object obj, String name) {
        Field field;
        Object value = null;
        try {
            field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            value = field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    
    public static void setField(Object obj, String name, String value) {
        Field field;
        try {
            field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            Class<?> type = field.get(obj).getClass();
            field.set(obj, convertObject(type, value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printObjectFields(Object obj) {
        System.out.println("Class : " + obj.getClass().getCanonicalName() );
        // find all fields
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields) {
            printObjectField(obj, field);
        }
    }
        
    public static void printObjectField(Object obj, Field field) {
        field.setAccessible(true);
        try{
            System.out.println(
                    "{ \"name\" : \"" +
                    field.getName() + 
                    "\", \"value\" : \"" + field.get(obj) + 
                    "\", \"type\" : \"" + field.getType().getCanonicalName() +
                    "\" },");
        }
        catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    
    public static Object convertObject(Class<?> type, String value) {
        if (type.equals(Boolean.class)) {
            return Boolean.valueOf(value);
        }
        else if (type.equals(Byte.class)) {
            return Byte.valueOf(value);
        }
        else if (type.equals(Character.class)) {
            return value.charAt(0);
        }
        else if (type.equals(Short.class)) {
            return Short.valueOf(value);
        }
        else if (type.equals(Integer.class)) {
            return Integer.valueOf(value);
        }
        else if (type.equals(Long.class)) {
            return Long.valueOf(value);
        }
        else if (type.equals(Float.class)) {
            return Float.valueOf(value);
        }
        else if (type.equals(Double.class)) {
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
