public class Fibonacci {
	static final int MAX = 50;

	static int[] results = new int[MAX]; 

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;

		results[0] = lo;

		int count = 1;
		while (hi < MAX) {
			results[count] = hi;
			count++;
			hi = lo + hi;
			lo = hi - lo;	

		}
		for(int i = 0; i< count; i++) {
			System.out.println(results[i]);
		}
	}
}


