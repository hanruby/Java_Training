package practice.ch03_Extending_Classes;

/**
 * P.95 
 * doubleの値の配列をソートするクラス。
 * このクラスは、データの交換、比較、および、値の検査の回数を SortMetrics クラスの中に記憶する。
 * @author ato
 *
 */
abstract class SortDouble {
    private double[] values; // ソートされる配列
    private final SortMetrics curMetrics = new SortMetrics(); // 測定された操作を記録するためのメトリクスオブジェクトへの参照を保持する

    /** 全ソートするために呼び出される */
    public final SortMetrics sort(double[] data) {
        values = data;
        curMetrics.init();
        doSort();
        return getMetrics();
    }

    /**
     * メトリクスデータのコピーを返す。
     * @return メトリクスデータのコピー
     */
    public final SortMetrics getMetrics() {
        return curMetrics.clone();
    }

    /** 拡張したクラスが要素の数を知るため */
    protected final int getDataLength() {
        return values.length;
    }

    /** 拡張したクラスが要素を調べるため */
    protected final double probe(int i) {
        curMetrics.probeCnt++;
        return values[i];
    }

    /** 拡張したクラスが要素を比較するため */
    protected final int compare(int i, int j) {
        curMetrics.compareCnt++;
        double d1 = values[i];
        double d2 = values[j];
        if (d1 == d2)
            return 0;
        else
            return (d1 < d2 ? -1 : 1);
    }

    /** 拡張したクラスが要素を交換するため */
    protected final void swap(int i, int j) {
        curMetrics.swapCnt++;
        double tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    /** 拡張したクラスが実装する -- ソートするのに使用される */
    protected abstract void doSort();
}

