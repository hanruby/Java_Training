package ch22.ex22_09;

import java.io.IOException;

import ch03.ex03_05.Benchmark;

public class CSVPatternBenchmark extends Benchmark{

    private CSV csv;
    private Readable source;
    private int cells_num;
    
    public CSVPatternBenchmark(CSV csv, Readable source, int cells_num) {
        this.csv = csv;
        this.source = source;
        this.cells_num = cells_num;
    }
    
    public void benchmark() {
        try {
            csv.readCSVTable(this.source, this.cells_num);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
}
