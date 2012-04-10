package ex03_05;

class CreateObjectBenchmark extends Benchmark {
    /** Objectを作成する */
    void benchmark() {
        @SuppressWarnings("unused")
        Object o = new Object();
    }

    public static void main(String[] args) {
        if(args.length != 1) {
			System.out.println("usage: java CreateObjectBenchmark [count]");
			return;
		}

        int count = Integer.parseInt(args[0]);
        long time = new CreateObjectBenchmark().repeat(count);
        System.out.println(count + " methods in " + time + " nanoseconds");
    }
}
