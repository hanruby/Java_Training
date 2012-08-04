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
            field.set(obj, ObjectUtility.convertObject(type, value));
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
    
    public static String getFieldValue(Object obj, Field field) {
        
        
        return null;
    }
}
