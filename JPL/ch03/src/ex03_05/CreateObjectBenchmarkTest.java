package ex03_05;

//import static org.junit.Assert.*;

import org.junit.Test;

public class CreateObjectBenchmarkTest {

    @Test
    public void testMain() {
        CreateObjectBenchmark.main(new String[]{"100"});
        CreateObjectBenchmark.main(new String[]{});
    }

}
