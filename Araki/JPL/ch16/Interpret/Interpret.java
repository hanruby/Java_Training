package ch16.Interpret;

import java.lang.reflect.*;


/**
 * Interpret for Java 
 * @author ato
 */
public class Interpret {
    public static void main(String[] args) {
        Object obj = createObject("java.util.HashMap");
        
        printObjectFields(obj);
        setField(obj, "threshold", 13);
        printObjectFields(obj);
    }
    
    
    static Object createObject(String str) {
        Class<?> cls = null;
        Object obj = null;

        // Create new Object
        try {
            cls = (Class<?>)Class.forName(str);
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
    
    public static void setField(Object obj, String name, Object value) {
        Field field;
        try {
            field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void printObjectFields(Object obj){
        System.out.println("Class : " + obj.getClass().getCanonicalName() );
        // find all fields
        Field[] fieldArr = obj.getClass().getDeclaredFields();
        for(Field field : fieldArr){
            printObjectField(obj, field);
        }
    }
        
    public static void printObjectField(Object o, Field field){
        field.setAccessible(true);
        try{
            System.out.println(
                    "  " +
                    field.getName() + " (" + field.get(o) + ") : " + 
                    field.getType().getCanonicalName() );
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
