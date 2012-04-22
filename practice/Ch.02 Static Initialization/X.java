
public class X {
	static int num = 24;
	static boolean b;
	static String str;
	static char c;
	
	static int num2;
	
	static {
		System.out.printf("X 1. %d %d %b %s %n",num, num2, b, str);
		num = Y.num;
		num2 = Y.num2;
		b = true;
		str = "hoge";
		System.out.printf("X 2. %d %d %b %s %n",num, num2, b, str);
	}
	
	public static int getNum() {
		return num;
	}
	
	public static boolean isB() {
		return b;
	}

	public static String getStr() {
		return str;
	}
	
	public static void main(String[] args) {
		System.out.printf("X 3. %d %b %s %n",num, b, str);
	}
}
