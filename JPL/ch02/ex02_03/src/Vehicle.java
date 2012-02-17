
public class Vehicle {
	private int currentSpeed;
	private int currentDirection;
	private String ownerName;
	
	// static field
	static public long nextVehicleId = 456;

	// field
	private long id;
		
	// Ex.02.04
	// id は不変な値を保持するはずなので、final宣言するべき
	
	public Vehicle(int speed, int direction, String name) {
		this.currentSpeed = speed;
		this.currentDirection = direction;
		this.ownerName = name;
		
		this.id = 0;
	}
	
	public void show() {
		System.out.println("  name:" + this.ownerName + 
				"  speed:" + this.currentSpeed +
				"  direction:" + this.currentDirection +
				"  id:" + this.id);
	}
	
	public static void main(String[] args) {
		Vehicle v = new Vehicle(100, 90, "hogehoge"); 
		v.show();
	}
}
