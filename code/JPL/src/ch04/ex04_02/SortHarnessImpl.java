package ch04.ex04_02;

/**
 * ex3.12 どのようなオブジェクト型でもソートできる一般的なクラス。
 * オブジェクトの順序の比較は toString の結果を利用する。
 * @author ato
 */
abstract class SortHarnessImpl implements SortHarness{
    private Object[] values; // ソートされる配列
    private final SortMetrics curMetrics = new SortMetrics(); // 測定された操作を記録するためのメトリクスオブジェクトへの参照を保持する

    /** 全ソートするために呼び出される */
    public final SortMetrics sort(Object[] data) {
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
    protected final Object probe(int i) {
        curMetrics.probeCnt++;
        return values[i];
    }

    /** 拡張したクラスが要素を比較するため */
    protected final int compare(int i, int j) {
        curMetrics.compareCnt++;
        Object o1 = values[i];
        Object o2 = values[j];
        return compMethod(o1, o2);
    }

    /**
     * ex3.12 オブジェクトの比較をおこなう。
     * 拡張したクラスが実装するのが望ましい。
     * @param o1 オブジェクト1
     * @param o2 オブジェクト2
     * @return 等しい場合:0, 右辺が小さい場合:負, 右辺が大きい場合:正 を返すこと。
     */
    protected abstract int compMethod(Object o1, Object o2);
    
    /** 拡張したクラスが要素を交換するため */
    protected final void swap(int i, int j) {
        curMetrics.swapCnt++;
        Object tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    /** 拡張したクラスが実装する -- ソートするのに使用される */
    protected abstract void doSort();
}
