package ch16.ex16_09;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashSet;
import java.util.Set;

/**
 * P.358 
 *
 */
public class ClassContents {
    
    private static Set<String> members = new HashSet<String>();
    
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName(args[0]);
            out.println(cls);
            searchType(cls);
            showMembers();
        } catch (ClassNotFoundException e) {
            System.out.println("unknown class: " + args[0]);
        }
    }
    
    static void searchType(Type type) {
        if (type == null) // 再帰呼び出し停止： スーパータイプが存在しない
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

        outputMembers(cls.getFields());
        outputMembers(cls.getConstructors());
        outputMembers(cls.getMethods());

        searchType(cls.getGenericSuperclass());
    }

    public static void showMembers() {
        for (String member : members) {
            out.println("  "+ member);
        }
    }
    
    
    // 標準出力に表示
    private static java.io.PrintStream out = System.out;

    public static void outputMembers(Member[] mems) {
        for (Member m : mems) {
            if (m.getDeclaringClass() == Object.class)
                continue;
            String decl = m.toString();
            members.add(outputAnnotation(m) + "%n  " + strip(decl, "java.lang."));
        }
    }
    
    public static String outputAnnotation(Object mem) {
        Annotation[] annotations = new Annotation[0];

        if (mem instanceof Field) {
            annotations = ((Field)mem).getAnnotations();
        }
        if (mem instanceof Constructor) {
            annotations = ((Constructor<?>)mem).getAnnotations();           
        }
        if (mem instanceof Method) {
            annotations = ((Method)mem).getAnnotations();
        }
        if (mem instanceof Class) {
            annotations = ((Class<?>)mem).getAnnotations();
        }
        
        String annotationInfo = "";
        for (Annotation annotation : annotations) {
            annotationInfo += annotation.toString();
        }
        return annotationInfo;
    }

    protected static String strip(String base, String stripString) {
        return base.replace(stripString, "");
    }
    
    public java.io.PrintStream getOut() {
        return out;
    }

    public void setOut(java.io.PrintStream out) {
        ClassContents.out = out;
    }
}
