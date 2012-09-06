package ch20.ex20_08;




import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class RandomAccessTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_() throws Exception {
        File file = new File("JPL/ch20/ex20_08/tablefile.txt");

        RandomAccess ra = new RandomAccess(file);
        
        ra.findEntryIndex();

        ra.randomPrint();
    }
}
