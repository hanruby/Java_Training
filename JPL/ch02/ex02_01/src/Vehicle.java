
public class Vehicle {
	private int currentSpeed;
	private int currentDirection;
	private String ownerName;
	
	public Vehicle(int speed, int direction, String name) {
		this.currentSpeed = speed;
		this.currentDirection = direction;
		this.ownerName = name;
	}
	
	public void show() {
		System.out.println("  name:" + this.ownerName + 
				"  speed:" + this.currentSpeed +
				"  direction:" + this.currentDirection);
	}
	
	public static void main(String[] args) {
		Vehicle v = new Vehicle(100, 90, "hogehoge"); 
		v.show();
	}
}
