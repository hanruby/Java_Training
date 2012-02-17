
public class Fibonacci {
   	static final String タイトル = "This is Fibonacci プログラム";
	static final int MAX = 50;
	
	public static void main(String[] args) {
		System.out.println(タイトル);
		
		int lo = 1;
		int hi = 1;

		System.out.println(lo);

		while (hi < MAX) {
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;	

		}
	}
}
