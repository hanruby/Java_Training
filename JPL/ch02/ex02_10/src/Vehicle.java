
public class Vehicle {
	private int currentSpeed;
	private int currentDirection;
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	static public long nextVehicleId = 0;
	
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

	private String ownerName;
	
	/**
	 * 初期化ブロック(P47)
	 */
	{
		this.setCurrentSpeed(0);
		this.setCurrentDirection(0);
		nextVehicleId++;
		this.id = nextVehicleId;
	}
	
	/**
	 * 引数なしコンストラクタ
	 */
	public Vehicle() {
		this.setOwnerName("none");
	}
	
	/**
	 * 所有者の名前を引数にとるコンストラクタ
	 */
	public Vehicle(String name) {
		this.setOwnerName(name);
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
