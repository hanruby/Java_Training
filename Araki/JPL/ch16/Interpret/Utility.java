package ch16.Interpret;

public class Utility {
    
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
