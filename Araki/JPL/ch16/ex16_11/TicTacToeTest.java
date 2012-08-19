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
    
    @Test
    public void test_isWin_Horizontal_1() throws Exception {		
        TicTacToe t = new TicTacToe();
        //
        t.setMark(0, 0, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(1, 0, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(2, 0, Mark.X);
        assertTrue(t.isWin());
        assertEquals(Mark.X, t.getWinner());
        t.printGrid();
    }
    
    @Test
    public void test_isWin_Horizontal_2() throws Exception {		
        TicTacToe t = new TicTacToe();
        //
        t.setMark(0, 1, Mark.O);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(1, 1, Mark.O);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(2, 1, Mark.O);
        assertTrue(t.isWin());
        assertEquals(Mark.O, t.getWinner());
        t.printGrid();
    }
    
    @Test
    public void test_isWin_Horizontal_3() throws Exception {		
        TicTacToe t = new TicTacToe();
        //
        t.setMark(0, 2, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(1, 2, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(2, 2, Mark.X);
        assertTrue(t.isWin());
        assertEquals(Mark.X, t.getWinner());
        t.printGrid();
    }
    
    @Test
    public void test_isWin_Vertical_1() throws Exception {		
        TicTacToe t = new TicTacToe();
        //
        t.setMark(0, 0, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(0, 1, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(0, 2, Mark.X);
        assertTrue(t.isWin());
        assertEquals(Mark.X, t.getWinner());
        t.printGrid();
    }

    @Test
    public void test_isWin_Vertical_2() throws Exception {		
        TicTacToe t = new TicTacToe();
        //
        t.setMark(1, 0, Mark.O);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(1, 1, Mark.O);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(1, 2, Mark.O);
        assertTrue(t.isWin());
        assertEquals(Mark.O, t.getWinner());
        t.printGrid();
    }

    @Test
    public void test_isWin_Vertical_3() throws Exception {		
        TicTacToe t = new TicTacToe();
        //
        t.setMark(2, 0, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(2, 1, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(2, 2, Mark.X);
        assertTrue(t.isWin());
        assertEquals(Mark.X, t.getWinner());
        t.printGrid();
    }

    @Test
    public void test_isWin_Diagonal_1() throws Exception {		
        TicTacToe t = new TicTacToe();
        //
        t.setMark(0, 0, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(1, 1, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(2, 2, Mark.X);
        assertTrue(t.isWin());
        assertEquals(Mark.X, t.getWinner());
        t.printGrid();
    }

    @Test
    public void test_isWin_Diagonal_2() throws Exception {		
        TicTacToe t = new TicTacToe();
        //
        t.setMark(0, 2, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(1, 1, Mark.X);
        assertFalse(t.isWin());
        assertEquals(Mark.None, t.getWinner());
        t.setMark(2, 0, Mark.X);
        assertTrue(t.isWin());
        assertEquals(Mark.X, t.getWinner());
        t.printGrid();
    }
    
    
}
