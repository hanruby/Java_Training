
public class Vehicle {
	private int currentSpeed;
	private int currentDirection;
	private String ownerName;
	
	public Vehicle(String name) {
		this.currentSpeed = 0;
		this.currentDirection = 0;
		this.ownerName = name;
	}
	
	public Vehicle() {
		this.currentSpeed = 0;
		this.currentDirection = 0;
		this.ownerName = "default";
	}
	
	public void setValue(int speed, int direction) {
		this.currentSpeed = speed;
		this.currentDirection = direction;

	}
	
	public void show() {
		System.out.println("  name:" + this.ownerName + 
				"  speed:" + this.currentSpeed +
				"  direction:" + this.currentDirection);
	}
	
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle("new car"); 
		Vehicle v2 = new Vehicle(); 
		v1.setValue(100, 23);
		v2.setValue(213, 34);
		v1.show();
		v2.show();
	}
}
