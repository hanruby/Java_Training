package ch16.ex16_11;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch16.ex16_11.TicTacToe.Mark;

public class TicTacToeTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testSetMark_exception_1() throws Exception {
        TicTacToe t = new TicTacToe();
        t.setMark(-1, 0, Mark.O);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetMark_exception_2() throws Exception {
        TicTacToe t = new TicTacToe();
        t.setMark(0, -1, Mark.O);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetMark_exception_3() throws Exception {
        TicTacToe t = new TicTacToe();
        t.setMark(2, 3, Mark.O);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetMark_exception_4() throws Exception {
        TicTacToe t = new TicTacToe();
        t.setMark(3, 2, Mark.O);
    }

    @Test
    public void testSetMark_O() throws Exception {		
        TicTacToe t = new TicTacToe();
        // 最初は成功
        assertTrue(t.setMark(0, 0, Mark.O));
        // 二回目はだめ
        assertFalse(t.setMark(0, 0, Mark.O));
    }

    @Test
    public void testSetMark_1() throws Exception {		
        TicTacToe t = new TicTacToe();
        // 最初は成功
        assertTrue(t.setMark(0, 1, Mark.X));
        // 二回目はだめ
        assertFalse(t.setMark(0, 1, Mark.X));
    }
}
