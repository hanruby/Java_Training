package ch03.ex03_03;

public class Y extends X{
	protected int yMask = getyMask(); // maskを取り出すメソッドを追加して、それを使ってmaskする 

	public Y() {
		showMask("Result of Y field initialization");
		fullMask |= yMask;
		showMask("Y constructor executed");
	}
	
	public int getyMask() {
		return 0xFF00;
	}
	
	public void showMask(String info) {
		System.out.printf("0x%04X 0x%04X 0x%04X : %s %n", xMask, yMask, fullMask, info);
	}
	
	public final int mask(int orig) {
		return (orig & getyMask());
	}

	public static void main(String[] args) {
		Y y = new Y();
		y.showMask("main");
	}
}
