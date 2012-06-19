package ch01.ex01_13;

class ImprovedFibonacci {

	static final int MAX_INDEX = 9;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

       	System.out.printf("1: %d%n", lo);  // NOTICE: \n ではなく %n を使うこと！！
       	
       	for (int i = 2; i <= MAX_INDEX; i++) {
       		if (hi % 2 == 0) {
       			mark = " *";
       		}
       		else {
                mark = "";
       		}

            System.out.printf("%d: %d %s%n",i, hi, mark); // NOTICE: \n ではなく %n を使うこと！！
            hi = lo + hi;
            lo = hi - lo;
        }
    }
}