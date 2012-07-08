package ch14.ex14_05;

public class Adder {
    private static int current_num = 0;
    
    public Adder() {
        current_num = 0;
    }
    
    public static void add(int num) {
        current_num = current_num + num;
        //System.out.println(this.current_num);
    }
    
    public static void sub(int num) {
        current_num = current_num - num;
    }
    
    public static int getNum() {
        return current_num;
    }
}
