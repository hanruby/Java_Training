package ch14.ex14_03;

public class Adder {
    private int num = 0;
    
    public Adder() {
        num = 0;
    }
    
    public void add(int num) {
        this.num = this.num + num;
        System.out.println(this.num);
    }
    
    public int getNum() {
        return this.num;
    }
}
