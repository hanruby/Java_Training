package ex03_03;

public class X {
	protected int xMask = getxMask();
	protected int fullMask;
	
	public X() {
		showMask("Result of X field initialization"); 
		fullMask = xMask;
		showMask("X constructor executed");

		System.out.printf("Mask is 0x%04X %n", this.mask(0xFFFF)); // 0xFF00 ではなく、0となってしまう
	}
	
	protected int getxMask() {
		showMask("Result of fields set to default values");
		return 0x00FF;
	}
	
	public void showMask(String info) {
		System.out.printf("0x%04X   none 0x%04X : %s %n", xMask, fullMask, info);
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}
}


