package ch02.ex02_18;

public class Vehicle {
	private int currentSpeed;
	private int currentDirection;
	private String ownerName;
	private long id;
	
	static private long nextVehicleId = 0;
	
	private enum TURN {LEFT, RIGHT};
	public static TURN TURN_LEFT = TURN.LEFT;
	public static TURN TURN_RIGHT = TURN.RIGHT;

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
	 * 引数なしコンストラクタ
	 */
	public Vehicle() {
		this.ownerName = "none";
		this.currentSpeed = 0;
		this.currentDirection = 0;
		nextVehicleId++;
		this.id = nextVehicleId;
	}
	
	/**
	 * 所有者の名前を引数にとるコンストラクタ
	 * @param name
	 */
	public Vehicle(String name) {
	    this();
		this.ownerName = name;
	}
	
	/**
	 * 所有者、スピード、進行方向を引数にとるコンストラクタ
	 * @param speed
	 * @param direction
	 * @param name
	 */
	public Vehicle(int speed, int direction, String name) {
	    this();
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
	public boolean turn(TURN turnDirection) {
		switch (turnDirection) {
		case LEFT:
			this.turn(-90);
			break;
		case RIGHT:
			this.turn(90);
			break;
		default:
			return false;
		}
		return true;
	}
	
	/**
	 * ex.2.18 コマンドラインで指定された名前を所有者として持つ車を作成する
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("usage: java Vehicle.class [owner name]");
			return;
		}

		Vehicle v = new Vehicle(args[0]);
		System.out.println(v.toString());
 	}
}
