package ch16.Interpret;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;


/**
 * Interpret for Java 
 * @author ato
 */
public class Interpret {
    public static void main(String[] args) {
        createInterpreter();        
    }
    
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    static void setReader(BufferedReader reader) {
        input = reader;
    }
    
    static void createInterpreter() {
        System.out.println("Welcome to java interpreter console.");
        
        String line = null;
        Object obj = null;
        
        for(;;) {
            System.out.printf("> ");
            try {
                line = input.readLine( );
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] args = line.split(" ");

            switch (args.length) {
            case 0:
                break;
                
            case 1:
                if (args[0].equals("ls")) {
                    if (obj == null) {
                        System.out.println("none");
                        break;
                    }
                    printObjectFields(obj);
                }
                else if (args[0].equals("exit")) {
                    System.out.println("bye!");
                    return;
                }
                break;

            case 2:
                if (args[0].equals("new")) {
                    obj = createObject(args[1]);
                }    
                break;

            case 3:
                if (args[0].equals("set")) {
                    setField(obj, args[1].toString(), args[2]);
                }    
                break;

            default:
                System.out.println(line);
                break;
            }
        }
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
