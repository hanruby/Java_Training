package ch14.ex14_03;

public class Adder {
    private int current_num = 0;
    
    public Adder() {
        current_num = 0;
    }
    
    public synchronized void add(int num) {
        this.current_num = this.current_num + num;
    }
    
    public int getNum() {
        return this.current_num;
    }
}
