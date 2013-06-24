package benchmark;

import org.junit.Test;

import practice.ch03_Extending_Classes.Benchmark;

public class Modulo {

    @Test
    public void BenchmarkModulo() throws Exception {
        int count = 100;
        long time = new CountModulo().repeat(count);
        System.out.println(count + " methods in " + time + " nanoseconds");
    }

    @Test
    public void BenchmarkReset() throws Exception {
        int count = 100;
        long time = new CountReset().repeat(count);
        System.out.println(count + " methods in " + time + " nanoseconds");
    }
}

abstract class BenchmarkCount extends Benchmark {
    static final int N = 1000;
}

class CountModulo extends BenchmarkCount {

    @Override
    public void benchmark() {
        int count = 0;
        while(true) {
            count++;

            if (count%N == 0) {
                break;
            }
        }
    }
}

class CountReset extends BenchmarkCount {

    @Override
    public void benchmark() {
        int count = 0;
        while(true) {
            count++;

            if (count == N) {
                count = 0;
                break;
            }
        }
    }
}
