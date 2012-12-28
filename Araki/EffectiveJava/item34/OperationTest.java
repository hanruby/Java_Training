package item34;

import org.junit.Before;
import org.junit.Test;

public class OperationTest {
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception {

        double x = 3.3;
        double y = 4.2;
        test(ExtendedOperation.class, x, y);
    }

    // enumのクラスを渡すことができる
    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for (Operation op : opSet.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
}
