package ch16.Interpret;

public class ObjectUtility {

    public static Object createObject(String str) {
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
}
