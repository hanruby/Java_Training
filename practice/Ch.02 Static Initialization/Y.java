
public class Y {
	static int num;
	static int num2 = 12;
	
	static {
		System.out.printf("Y 1. %d %n",num);		
		num = X.getNum();
		System.out.printf("Y 2. %d %n",num);	
	}

	public int getNum() {
		return num;
	}
}
