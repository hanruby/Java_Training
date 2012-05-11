package ch02.ex02_09;


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
	
	public void setValue(int speed, int direction, String name) {
		this.setCurrentSpeed(speed);
		this.setCurrentDirection(direction);
		this.setOwnerName(name);
	}

	public void setValue(int speed, int direction) {
		this.setCurrentSpeed(speed);
		this.setCurrentDirection(direction);
	}
	
	public void show() {
		System.out.println("  name:" + this.ownerName + 
				"  speed:" + this.currentSpeed +
				"  direction:" + this.currentDirection +
				"  id:" + this.id);
	}
	
	/**
	 * 識別番号の最大値を返すメソッド ex2.9
	 * @return
	 */
	public static long getMaxId() {
		return nextVehicleId;
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
