package ch16.Interpret;

import java.lang.reflect.*;

public class MethodUtility {

    public static Object execMethod(Object obj, int method_number, String argstr) {
        Object ret = null;
        
        Method[] methods = obj.getClass().getDeclaredMethods();
        Method method = methods[method_number]; 
        method.setAccessible(true);
        
        String[] args = argstr.split(",");
        Class<?>[] types = method.getParameterTypes();
        Object[] objs = new Object[types.length];
        
        for (int i = 0; i < types.length; i++) {
            objs[i] = FieldUtility.convertObject(types[i], args[i]);
        }
        
        try {
            ret = method.invoke(obj, objs);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        
        return ret;
    }
    
    public static void printObjectMethods(Object obj) {
        System.out.println("Class : " + obj.getClass().getCanonicalName() );
        // find all methods
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            printObjectMethod(obj, method);
        }
    }
    
    public static void printObjectMethod(Object obj, Method method) {
        method.setAccessible(true);
        System.out.println(method.toString());
    }
}
