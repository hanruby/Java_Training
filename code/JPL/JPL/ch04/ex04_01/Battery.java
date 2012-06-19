package ch04.ex04_01;

public class Battery implements EnergySource {

    private static int MAX = 100;
    private int percentage = 0;
    
    @Override
    public boolean empty() {
        return (percentage == 0);
    }

    @Override
    public int charge(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The charge amount should not be negative value");
        }
        
        int total = this.percentage + amount;
        if( total  >= MAX ) {
            this.percentage = MAX;
            // 過剰にチャージした分は無効
            return 0;
        } 
        else {
            this.percentage = total;
            return 0;
        }
    }
    
    @Override
    public boolean fullness() {
        return (percentage == MAX);
    }

    @Override
    public int remain() {
        return percentage;
    }
}
