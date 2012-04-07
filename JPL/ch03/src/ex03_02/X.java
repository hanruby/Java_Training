package ex03_02;

public class X {
	protected int xMask = 0x00FF;
	protected int fullMask;
	
	public X() {
		fullMask = xMask;
	}
	
	public int mask(int orig) {
		return (orig & fullMask);
	}
}


