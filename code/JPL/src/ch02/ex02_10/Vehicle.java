package ch02.ex02_10;


public class Vehicle {
	private int currentSpeed;
	private int currentDirection;
	private String ownerName;
	private long id;
	
	static public long nextVehicleId = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public int getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * 引数なしコンストラクタ
	 */
	public Vehicle() {
		this.ownerName = "none";
		this.currentSpeed = 0;
		this.currentDirection = 0;
	}
	
	/**
	 * 所有者の名前を引数にとるコンストラクタ
	 * @param name
	 */
	public Vehicle(String name) {
		this.ownerName = name;
		this.currentSpeed = 0;
		this.currentDirection = 0;
	}
	
	/**
	 * 所有者、スピード、進行方向を引数にとるコンストラクタ
	 * @param speed
	 * @param direction
	 * @param name
	 */
	public Vehicle(int speed, int direction, String name) {
		this.ownerName = name;
		this.currentSpeed = speed;
		this.currentDirection = direction;
	}

	{
		nextVehicleId++;
		this.id = nextVehicleId;
	}
	
	public void setValue(int speed, int direction, String name) {
		this.setCurrentSpeed(speed);
		this.setCurrentDirection(direction);
		this.setOwnerName(name);
	}

	public void setValue(int speed, int direction) {
		this.setCurrentSpeed(speed);
		this.setCurrentDirection(direction);
	}
	
	/**
	 * 識別番号の最大値を返すメソッド ex2.9
	 * @return
	 */
	public static long getMaxId() {
		return nextVehicleId;
	}
	
	/**
	 * toString ex2.10
	 */
	public String toString() {
		return "  name:" + this.ownerName + 
					  "  speed:" + this.currentSpeed +
					  "  direction:" + this.currentDirection +
					  "  id:" + this.id;
	}
	
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle("new car"); 
		Vehicle v2 = new Vehicle(); 
		v1.setValue(100, 23);
		v2.setValue(213, 34);
		System.out.println(v1);
		System.out.println(v2);
 	}
}
