package ch01.ex01_12;

class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	static String[] results = new String[MAX_INDEX]; 

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		results[0] = "1: " + lo;
       	       	
       	for (int i = 2; i <= MAX_INDEX; i++) {
       		if (hi % 2 == 0) {
       			mark = " *";
       		}
       		else {
                mark = "";
       		}

            results[i-1] = i + ": " + hi + mark;
            hi = lo + hi;
            lo = hi - lo;
        }
       	
       	for (String res : results) {
       		System.out.println(res);
       	}
    }
}