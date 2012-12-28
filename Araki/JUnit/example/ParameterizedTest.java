package example;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    // テストパラメータの設定
    private int x;
    private int y;
    private int expected;
    
    public ParameterizedTest(int x, int y, int expected){
        this.x = x;
        this.y = y;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        // テストするパラメータをここに追加する
        Object[][] data = new Object[][] {
                {1, 1, 2},
                {10, 10, 20},
                {10, 20, 30},
        };
        return Arrays.asList(data);
    }
 
    @Test
    public void test_add() throws Exception {
        assertEquals(expected, x + y);
    }
}