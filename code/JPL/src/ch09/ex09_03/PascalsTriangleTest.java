package ch07.ex07_03;


import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PascalsTriangleTest {

    private PascalsTriangle pascalsTriangle;

    @Before
    public void setUp() throws Exception {
        pascalsTriangle = new PascalsTriangle();
    }
    
    @Test
    public void testTriangle() throws Exception {
        // 三角形の形に初期化されているかを確認する
        int[][] triangle = pascalsTriangle.getPascalsTriangle();
        for (int depth = 0; depth < triangle.length; depth++) {
            assertEquals(depth + 1, triangle[depth].length);
        }
    }
    
    @Test
    public void testPascalsTriangle() throws Exception {
        
        int[][] correctPascalsTriangle = {
                { 1 },
                { 1, 1 },
                { 1, 2, 1 },
                { 1, 3, 3, 1 },
                { 1, 4, 6, 4, 1 },
                { 1, 5, 10, 10, 5, 1 },
                { 1, 6, 15, 20, 15, 6, 1 },
                { 1, 7, 21, 35, 35, 21, 7, 1 },
                { 1, 8, 28, 56, 70, 56, 28, 8, 1 },
        };
        
        int[][] triangle = pascalsTriangle.getPascalsTriangle();
        for (int depth = 0; depth < correctPascalsTriangle.length; depth++) {
            for (int k = 0; k < correctPascalsTriangle[depth].length; k++) {
                assertEquals(correctPascalsTriangle[depth][k], triangle[depth][k]);
            }
        }

        // 配列を無理やり表示する　
        System.out.println(Arrays.deepToString(triangle));
    }
    
    @Test
    public void testCreateOtherTriangle() throws Exception {
        pascalsTriangle = new PascalsTriangle(15);
        assertEquals(15, pascalsTriangle.getPascalsTriangle().length);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArg() throws Exception {
        pascalsTriangle = new PascalsTriangle(0);
    }
}
