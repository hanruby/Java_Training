package ex03_02;

public class Y extends X{
	protected int yMask = 0xFF00;
	
	public Y() {
		fullMask |= yMask;
	}
	
	public static void main(String[] args) {
		Y y = new Y();
		System.out.println(y);
	}
}
