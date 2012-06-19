package ch09.ex09_03;

/**
 * パスカルの三角形を生成する
 * @author ato
 *
 */
public class PascalsTriangle {
    private static int DEFAULT_DEPTH = 12; // 深さ
    
    private int[][] triangle; // 三角形を格納する２次元配列
    
    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt);
    }
    
    public PascalsTriangle() {
        // パスカルの三角形を作成する
        createPascalsTriangle(DEFAULT_DEPTH);
    }
    
    public PascalsTriangle(int triangleDepth) {
        if (triangleDepth < 1) {
            throw new IllegalArgumentException("The triangle depth should not be negative value");
        }
        createPascalsTriangle(triangleDepth);
    }
    
    /**
     * パスカルの三角形を作成する
     */
    private void createPascalsTriangle(int triangleDepth) {
        triangle = new int[triangleDepth][];
        for (int depth = 0; depth < triangle.length; depth++) {
            triangle[depth] = new int[depth + 1];
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
        return ((n == 0) || (n == k) || (k == 0) ? 1 : triangle[n-1][k-1] + triangle[n-1][k] ); // ex09_03 条件演算子（三項演算子）を用いて書きなおした。分かりやすくなったかといえば、分かりにくくなった気がする。。。
    }
    
    /**
     * パスカルの三角形を返す
     * @return パスカルの三角形
     */
    public int[][] getPascalsTriangle() {
        return triangle.clone();
    }
    
    @Override
    public String toString() {
        String desc = "";
        for (int depth = 0; depth < triangle.length; depth++) {
            desc += "{ ";
            for (int k = 0; k < triangle[depth].length; k++) {
                desc += triangle[depth][k];
                desc += (k == triangle[depth].length -1 ? " },\n" : ", ");  // ex09_03 条件演算子（三項演算子）を用いて書きなおした。分かりやすくはなってない。。
            }
        }
        return desc;
    }
}
