package ch14.ex14_04;

public class Adder {
    private static int current_num = 0;
    
    public Adder() {
        current_num = 0;
    }
    
    public synchronized static void add(int num) {
        current_num = current_num + num;
        //System.out.println(this.current_num);
    }
    
    public static int getNum() {
        return current_num;
    }
}
