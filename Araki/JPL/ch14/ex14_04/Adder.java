package ch14.ex14_04;

public class Adder {
    private int current_num = 0;
    
    public Adder() {
        current_num = 0;
    }
    
    public synchronized void add(int num) {
        this.current_num = this.current_num + num;
        //System.out.println(this.current_num);
    }
    
    public int getNum() {
        return this.current_num;
    }
}
