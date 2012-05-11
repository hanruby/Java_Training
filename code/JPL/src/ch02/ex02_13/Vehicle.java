package ch02.ex02_13;

public class Vehicle {
	private int currentSpeed; // 値が変更された場合の処理を入れることが出来なくなるため、privateにすべき
	private int currentDirection; // 上と同じ理由により、privateにすべき
	private String ownerName; // 上と同じ
	private long id; // 上と同じ
	
	static private long nextVehicleId = 0; // シーケンスで与えるIDであるため、privateにすべき

	// IDを取得するメソッドは必要
	public long getId() {
		return id;
	}

	// IDをセットするメソッドは不要
	//public void setId(long id)
		
	// speedを取得するメソッドは必要
	public int getCurrentSpeed() {
		return currentSpeed;
	}

	// speedを設定するメソッドは必要
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	// directionを取得するメソッドは必要
	public int getCurrentDirection() {
		return currentDirection;
	}

	// directionを設定するメソッドは必要
	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}

	// nameを取得するメソッドは必要
	public String getOwnerName() {
		return ownerName;
	}

	// nameを設定するメソッドは必要かな
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
