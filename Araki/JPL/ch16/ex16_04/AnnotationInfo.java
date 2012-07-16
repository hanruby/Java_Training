package ch16.ex16_04;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class AnnotationInfo {

    // 標準出力に表示
    private static java.io.PrintStream out = System.out;

    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName(args[0]);
            showAnnotations(cls);
        } catch (ClassNotFoundException e) {
            System.out.println("unknown class: " + args[0]);
        }
    }

    private static void showAnnotations(Type type) {
        if (type == null) 
            return;
        
        Class<?> cls = null;
        if (type instanceof Class<?>) {
            cls = (Class<?>) type;
        }
        else if (type instanceof ParameterizedType) {
            cls = (Class<?>) ((ParameterizedType)type).getRawType();
        }
        else {
            throw new Error("Unexpected non-class type");
        }
        
        Annotation[] annotations = cls.getAnnotations();
        
        for (Annotation annotation : annotations) {
            out.println(annotation.toString());
        }
    }
}
