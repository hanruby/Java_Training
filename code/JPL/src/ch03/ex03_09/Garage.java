package ch03.ex03_09;

import ch03.ex03_08.Vehicle;

public class Garage implements Cloneable{
    Vehicle[] vehicles;
    
    public Garage(Vehicle[] vehicles) {
        if (vehicles == null) {
            throw new IllegalArgumentException("argument is null");
        }
        this.vehicles = vehicles;
    }
    
    public Vehicle[] getVehicles() {
        return this.vehicles;
    }
    
    /**
     * ex03.09 clone
     * 深いコピー
     * ただし、Vehicleの ID は別のものを与える
     */
    @Override
    protected Garage clone() {
        Vehicle[] vehicles = new Vehicle[this.vehicles.length];
        
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = this.vehicles[0].clone();
        }
            
        Garage g = new Garage(vehicles);

        return g;
    }
}
