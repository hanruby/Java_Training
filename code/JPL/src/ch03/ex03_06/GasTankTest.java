package ch03.ex03_06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GasTankTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test1() {
        int remain = 0;
        
        // tank の量を 120 で初期化
        GasTank gas = new GasTank(120);
        assertEquals(true, gas.empty());
        assertEquals(false, gas.fullness());
        assertEquals(0, gas.remain());
        
        // 100 補給
        remain = gas.charge(100);
        assertEquals(0, remain);
        assertEquals(false, gas.empty());
        assertEquals(false, gas.fullness());
        assertEquals(100, gas.remain());
        
        // 10 補給
        remain = gas.charge(10);
        assertEquals(0, remain);
        assertEquals(false, gas.empty());
        assertEquals(false, gas.fullness());
        assertEquals(110, gas.remain());

        // 20 補給（10余り）
        remain = gas.charge(20);
        assertEquals(10, remain);
        assertEquals(false, gas.empty());
        assertEquals(true, gas.fullness());
        assertEquals(120, gas.remain());
    }

}
