
public class Sum {
//	static int sum(int[] numbers) {     // 配列パラメータ
	static int sum(int... numbers) {    // 可変長パラメータ
		int total = 0;
		for (int value: numbers) {
			total += value;
		}
		return total;
	}
	
	public static void main(String[] args) {
		System.out.printf("%d %n",
						  sum(1,2,3,4,5));
	}
}
