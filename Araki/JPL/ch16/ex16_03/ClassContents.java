package ch16.ex16_03;

import java.lang.reflect.*;

/**
 * P.358 
 *
 */
public class ClassContents {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName(args[0]);
            System.out.println(c);
            printMembers(c.getFields());
            printMembers(c.getConstructors());
            printMembers(c.getMethods());
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

        System.out.println(cls);
        
        printMembers(cls.getFields());
        printMembers(cls.getConstructors());
        printMembers(cls.getMethods());

                
        searchType(cls.getGenericSuperclass());
    }

    // 標準出力に表示
    private static java.io.PrintStream out = System.out;

    public static void printMembers(Member[] mems) {
        for (Member m : mems) {
            if (m.getDeclaringClass() == Object.class)
                continue;
            String decl = m.toString();
            out.print("    ");
            out.println(strip(decl, "java.lang."));
        }
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
