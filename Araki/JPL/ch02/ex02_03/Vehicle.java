package ch02.ex02_03;


public class Vehicle {
	private int currentSpeed;
	private int currentDirection;
	private String ownerName;
	
	// static field
	static public long nextVehicleId = 0;

	// field
	private long id;
		
	// Ex.02.04
	// id は不変な値を保持するはずなので、final宣言するべき
	
	public Vehicle(int speed, int direction, String name) {
		this.currentSpeed = speed;
		this.currentDirection = direction;
		this.ownerName = name;
		nextVehicleId++;
		this.id = nextVehicleId;
	}
	
	public void show() {
		System.out.println("  name:" + this.ownerName + 
				"  speed:" + this.currentSpeed +
				"  direction:" + this.currentDirection +
				"  id:" + this.id);
	}
	
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle(100, 90, "hogehoge"); 
		Vehicle v2 = new Vehicle(100, 90, "hogehoge"); 
		v1.show();
		v2.show();
	}
}
