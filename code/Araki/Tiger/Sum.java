
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
						  sum(5,6,7,8,9));  // 可変長パラメータ

		int[] arr = {1,2,3,4,5};
		System.out.printf("%d %n",
						  sum(arr)); // 配列パラメータ
	}
}
