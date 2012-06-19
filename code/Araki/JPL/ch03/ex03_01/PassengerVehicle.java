package ch03.ex03_01;

public class PassengerVehicle extends Vehicle{
	private int seatNum;
	private int occupiedNum;

	public PassengerVehicle(String ownerName, int seatNum, int occupiesNum) {
		super(ownerName);
		this.seatNum = seatNum;
		this.occupiedNum = occupiesNum;
	}
	
	public int getSeatNum() {
		return seatNum;
	}
	
	public int getOccupiedNum() {
		return occupiedNum;
	}
	
	@Override
	public String toString() {
		return super.toString() + " seat:" + this.seatNum
								+ " occupied:" + this.occupiedNum;
	}
	
	public static void main(String[] args) {
		PassengerVehicle familyCar = new PassengerVehicle("Hadson", 4, 3);
		familyCar.setCurrentSpeed(100);
		familyCar.setCurrentDirection(134);
				
		PassengerVehicle sportsCar = new PassengerVehicle("Jenkins", 2, 2);
		sportsCar.setCurrentSpeed(340);
		sportsCar.setCurrentDirection(135);
		
		System.out.println(familyCar);
		System.out.println(sportsCar);
	}
}
