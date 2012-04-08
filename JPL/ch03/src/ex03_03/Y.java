package ex03_03;

public class Y extends X{
	protected int yMask = 0xFF00;

	public Y() {
		showMask("Result of Y field initialization");
		fullMask |= yMask;
		showMask("Y constructor executed");
	}
	
	public void showMask(String info) {
		System.out.printf("0x%04X 0x%04X 0x%04X : %s %n", xMask, yMask, fullMask, info);
	}
	
	public int mask(int orig) {
		return (orig & yMask);
	}

	public static void main(String[] args) {
		Y y = new Y();
		y.showMask("main");
	}
}
