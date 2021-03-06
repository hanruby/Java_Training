package ch16.ex16_09;

import java.lang.reflect.*;

/**
 * P.352
 */
public class TypeDesc {
    public static void main(String[] args) {
        TypeDesc desc = new TypeDesc();
        for (String name : args) {
            try {
                Class<?> startClass = Class.forName(name);
                desc.printType(startClass, 0, basic);
            } catch (ClassNotFoundException e) {
                System.err.println(e);  // report the error
            }
        }
    }

    // 標準出力に表示
    private java.io.PrintStream out = System.out;

    // 型名にラベル付けする printType() で使用する
    public final static String[]
                          basic   = { "class",   "interface", "enum",    "annotation", "nested class", "nested interface" },
                          supercl = { "extends", "implements" },
                          iFace   = { null,       "extends"  };

    public void printType(Type type, int depth, String[] labels) {
        if (type == null) // 再帰呼び出し停止： スーパータイプが存在しない
            return;

        // Type を Class オブジェクトに変換する
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

        // ex16_01 Objectクラスに関しては何も表示しない
        if (cls == java.lang.Object.class) {
            return;
        }
                
        // Annotationを表示
        String annotation = ClassContents.outputAnnotation(cls);
        if (annotation != null) {
            out.println(annotation);
        }

        // 型を表示
        for (int i = 0; i < depth; i++)
            out.print("  ");
        int kind = cls.isMemberClass() && cls.isInterface() ? 5 :
                   cls.isMemberClass() ? 4 :
                   cls.isAnnotation() ? 3 :
                   cls.isEnum() ? 2 :
                   cls.isInterface() ? 1 : 0;
        
        // ラベルを表示
        out.print(labels[kind] + " ");

        // 
        out.print(cls.getCanonicalName());

        // 存在すれば、ジェネリック型パラメータを表示
        TypeVariable<?>[] params = cls.getTypeParameters();
        if (params.length > 0) {
            out.print('<');
            for (TypeVariable<?> param : params) {
                out.print(param.getName());
                out.print(", ");
            }
            out.println("\b\b>");
        }
        else { 
            out.println();
        }

        // ex16_02 ネストした型に対して再帰
        Class<?> enclosing = cls.getEnclosingClass();
        if (enclosing != null) {
            printType(enclosing, depth + 1, basic);
        }

        // このクラスが実装している全てのインターフェースを表示
        Type[] interfaces = cls.getGenericInterfaces();
        for (Type iface : interfaces) {
            printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
        }
        
        // スーパークラスに対して再帰
        printType(cls.getGenericSuperclass(), depth + 1, supercl);
    }

    public java.io.PrintStream getOut() {
        return out;
    }

    public void setOut(java.io.PrintStream out) {
        this.out = out;
    }
}
