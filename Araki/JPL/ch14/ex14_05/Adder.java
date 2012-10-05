package ch14.ex14_05;

public class Adder {
    private static int current_num = 0;
    
    public Adder() {
        current_num = 0;
    }
    
    public static void add(int num) {
        synchronized (Adder.class) {
            current_num = current_num + num;
        }
    }
    
    public static void sub(int num) {
        synchronized (Adder.class) {
            current_num = current_num - num;
        }
    }
    
    public static int getNum() {
        synchronized (Adder.class) {
            return current_num;
        }
    }
}
