package practice.ch03_Extending_Classes;

/**
 * P.96 
 * 特定のソートの実行のコストを記述する。
 * 唯一の役割は、データを保持することであり、アクセッサーメソッドを要してデータのアクセスする必要はない。
 * 
 * @author ato
 *
 */
final class SortMetrics implements Cloneable {
    public long probeCnt,       // 単純なデータの値調査
                compareCnt,     // ２つの要素の比較
                swapCnt;        // ２つの要素の交換

    public void init() {
        probeCnt = swapCnt = compareCnt = 0;
    }

    public String toString() {
        return probeCnt + " probes " +
               compareCnt + " compares " +
               swapCnt + " swaps";
    }

    /** clone */
    public SortMetrics clone() {
        try {
            // デフォルトの仕組みで十分
            return (SortMetrics) super.clone(); 
        } catch (CloneNotSupportedException e) {
            // 起こりえない。このクラスと Object は複製できる
            throw new InternalError(e.toString());
        }
    }
}




