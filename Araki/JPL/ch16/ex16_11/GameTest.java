package ch16.ex16_11;


import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void test_getNextPlayer() throws Exception {
        Game g = new Game();
        Method method = Game.class.getDeclaredMethod("getNextPlayer");
        method.setAccessible(true);
        {
            String result = (String) method.invoke(g);
            assertEquals("hoge", result);
        }
        {
            String result = (String) method.invoke(g);
            assertEquals(null, result);
        }
    }

    @Test
    public void test_getNextPlayer2() throws Exception {
        Game g = new Game();
        Method method = Game.class.getDeclaredMethod("getNextPlayer");
        method.setAccessible(true);
        {
            String result = (String) method.invoke(g);
            assertEquals("hoge", result);
        }
        {
            String result = (String) method.invoke(g);
            assertEquals(null, result);
        }
    }

}
