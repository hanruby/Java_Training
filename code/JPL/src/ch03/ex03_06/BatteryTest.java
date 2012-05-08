package ch03.ex03_06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BatteryTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test1() {
        int remain = 0;
        
        // batteryを初期化
        Battery battery = new Battery();
        assertEquals(true, battery.empty());
        assertEquals(false, battery.fullness());
        assertEquals(0, battery.remain());
        
        // 80 補給
        remain = battery.charge(80);
        assertEquals(0, remain);
        assertEquals(false, battery.empty());
        assertEquals(false, battery.fullness());
        assertEquals(80, battery.remain());
        
        // 10 補給
        remain = battery.charge(10);
        assertEquals(0, remain);
        assertEquals(false, battery.empty());
        assertEquals(false, battery.fullness());
        assertEquals(90, battery.remain());

        // 20 補給（10余り）
        remain = battery.charge(20);
        assertEquals(0, remain);
        assertEquals(false, battery.empty());
        assertEquals(true, battery.fullness());
        assertEquals(100, battery.remain());
    }

}
