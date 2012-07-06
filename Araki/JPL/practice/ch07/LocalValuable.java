package practice.ch07;

@SuppressWarnings("unused")

public class LocalValuable {
    void foo() {
        
        // must final
        final int i = 0;
        
        class X {
            void print() {
                System.out.println(i);
            }
        }
        
        X x = new X();
    }
}
