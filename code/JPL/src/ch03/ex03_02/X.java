package ex03_02;

public class X {
	protected int xMask = getMask(); // 4. Xのフィールドの初期化 
	protected int fullMask;
	
	public X() { // 5. Xのコンストラクタが実行される
		super(); // 3. Objectのコンストラクタが呼び出される
		showMask("Result of X field initialization"); 
		fullMask = xMask;
		showMask("X constructor executed");
	}
	
	private int getMask() {
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


