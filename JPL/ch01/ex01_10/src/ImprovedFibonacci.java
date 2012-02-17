class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	static FibResult[] fib = new FibResult[MAX_INDEX];
	
	static class FibResult {
		private int result;
		private boolean even;
		
		public FibResult(int lo, boolean b) {
			result = lo;
			even = b;
		}

		public void show() {
			String mark;
			
       		if (even) {
       			mark = " *";
       		}
       		else {
                mark = "";
       		}
			System.out.println(this.result + mark);
		}
	}
	
	public static void main(String[] args) {

		int lo = 1;
		int hi = 1;

		fib[0] = new FibResult(lo, false);
       	
       	for (int i = 2; i <= MAX_INDEX; i++) {
       		fib[i-1] = new FibResult(hi, hi % 2 == 0);
            
            hi = lo + hi;
            lo = hi - lo;
        }
       	
       	for (FibResult f : fib) {
       		if (f != null) {
       			f.show();	
       		}
       	}
    }
}