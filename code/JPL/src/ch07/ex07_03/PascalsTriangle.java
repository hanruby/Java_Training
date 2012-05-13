package ch07.ex07_03;

/**
 * パスカルの三角形を生成する
 * @author ato
 *
 */
public class PascalsTriangle {
    static int DEPTH = 12; // 深さ
    
    private int[][] triangle; // 三角形を格納する２次元配列
    
    public PascalsTriangle() {
        // パスカルの三角形を格納する配列を初期化する
        triangle = new int[DEPTH][];
        for(int depth = 0; depth < DEPTH; depth++) {
            triangle[depth] = new int[depth + 1];
        }
        
        createPascalsTriangle();
    }
    
    /**
     * パスカルの三角形を作成する
     */
    private void createPascalsTriangle() {
        for (int depth = 0; depth < triangle.length; depth++) {
            for (int k = 0; k < triangle[depth].length; k++) {
                triangle[depth][k] = rule(depth,k);
            }
        }
    }
    
    /**
     * パスカルのルール
     * @param n 深さ
     * @param k 左からのインデックス
     * @return
     */
    private int rule(int n, int k) {
        // check of negative value
        if (n < 0 || k < 0) {
            throw new IllegalArgumentException("Value of n and k should not be negative argument");
        }
        
        // 深さ１、先頭、または、最後の要素はすべて1を返す
        if ((n == 0) || (n == k) || (k == 0)) {
            return 1;
        }

        return triangle[n-1][k-1] + triangle[n-1][k];
    }
    
    /**
     * パスカルの三角形を返す
     * @return パスカルの三角形
     */
    public int[][] getPascalsTriangle() {
        return triangle.clone();
    }
}
