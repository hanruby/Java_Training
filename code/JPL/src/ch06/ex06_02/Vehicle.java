package ch06.ex06_02;

public class Vehicle {
	private int currentSpeed;
	private int currentDirection;
	private String ownerName;
	private long id;
	
	static private long nextVehicleId = 0;
	
	/* ex06_02 
	 * 利点：
	 * enumを利用することで、指定されたTURNのみを受け取ることができる
	 */
	public enum Turn {TURN_LEFT, TURN_RIGHT};
	
	//! IDを取得するメソッド
	public long getId() {
		return id;
	}

	//! speedを取得するメソッド
	public int getCurrentSpeed() {
		return currentSpeed;
	}

	//! speedを設定するメソッド
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	//! directionを取得するメソッド
	public int getCurrentDirection() {
		return currentDirection;
	}

	//! directionを設定するメソッド
	public void setCurrentDirection(int currentDirection) {
		this.currentDirection = currentDirection;
	}

	//! nameを取得するメソッド
	public String getOwnerName() {
		return ownerName;
	}

	//! nameを設定するメソッド
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

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

	public Vehicle(int speed, int direction, String name) {
		this.setValue(speed, direction, name);
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
	
	/**
	 * ex2.15 乗り物の現在のスピードを引数で渡された値に変更する
	 */
	public void changeSpeed(int speed) {
		this.currentSpeed = speed;
		System.out.println("changed speed : " + speed);
	}
	
	/**
	 * ex2.15 スピードをゼロにする
	 */
	public void stop() {
		this.currentSpeed = 0;
		System.out.println("stopped");
	}
	
	/**
	 * ex.2.17 回転する角度を受け付ける
	 * @param rot
	 */
	public boolean turn(int rot) {
		this.currentDirection = (this.currentDirection + rot) % 360;
		return true;
	}
	
	/**
	 * ex.2.17 定数
	 * @param turnDirection
	 * @return
	 */
	public boolean turn(Turn turnDirection) {
		switch (turnDirection) {
		case TURN_LEFT:
			this.turn(-90);
			break;
		case TURN_RIGHT:
			this.turn(90);
			break;
		default:
			return false;
		}
		return true;
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
