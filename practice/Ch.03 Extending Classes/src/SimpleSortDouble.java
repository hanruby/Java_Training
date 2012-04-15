
/**
 * P.97
 * SortDoubleの拡張。単純なソートアルゴリズム（「選択ソート」）で doSortを実装している。
 * 利点：コードを書くのが簡単で、理解も簡単。
 * @author ato
 *
 */
class SimpleSortDouble extends SortDouble {
    protected void doSort() {
        for (int i = 0; i < getDataLength(); i++) {
            for (int j = i + 1; j < getDataLength(); j++) {
                if (compare(i, j) > 0)
                    swap(i, j);
            }
        }
    }
}

