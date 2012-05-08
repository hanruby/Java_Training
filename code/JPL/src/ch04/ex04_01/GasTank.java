package ch04.ex04_01;

public class GasTank implements EnergySource {

    private int TANK_MAX;
    private int tank = 0;
    
    public GasTank(int tankmax) {
        if (tankmax <= 0) {
            throw new IllegalArgumentException("The charge amount should not be negative value");
        }
        TANK_MAX = tankmax;
    }

    @Override
    public boolean empty() {
        return (tank == 0);
    }
    
    @Override
    public int charge(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The charge amount should not be negative value");
        }
        
        int total = this.tank + amount;
        if( total  >= TANK_MAX ) {
            this.tank = TANK_MAX;
            return total - this.tank; 
        } 
        else {
            this.tank = total;
            return 0;
        }
    }

    @Override
    public boolean fullness() {
        return (this.tank == TANK_MAX);
    }

    @Override
    public int remain() {
        return tank;
    }
}
