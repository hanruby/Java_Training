package ch21.ex21_04;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 別のイテレータからStringオブジェクトを読み出して、
 * 指定された長さより短い文字列オブジェクトだけを返すイテレータ型
 * @see JPL P.536
 */
public class ShortStrings implements Iterator<String> {
    private Iterator<String> strings;  // 元の文字列
    private String nextShort;      // 次が不明ならnull
    private final int maxLen;      // この長さ以下の文字列を返す

    /**
     * 
     * @param strings 文字列を提供するイテレータ 
     * @param maxLen 最大長
     */
    public ShortStrings(Iterator<String> strings, int maxLen) {
        this.strings = strings;
        this.maxLen = maxLen;
        nextShort = null;
    }

    /**
     * @return 次の短い文字列を検索して、存在すればtrueを返す。
     *         見つけることなく、文字列元のイテレータが終わると、falseを返す。
     */
    public boolean hasNext() {
        /* hasNextの設計:
         * nextの前に複数回呼び出されても動作するようになっている ← 必須事項
         * 
         */
        // すでに見つけた
        if (nextShort != null) {
            return true;
        }
        // 検索...
        while (strings.hasNext()) {
            // nextShortに見つけた内容を記憶
            nextShort = strings.next();
            if (nextShort.length() <= maxLen) // 見つけた
                return true;
        }
        // 見つからなかった
        nextShort = null;
        return false;
    }

    /**
     * @return 次の短い文字列が存在するかを調べ、存在すればそれを返す
     * @throws NoSuchElementException 何も返すものがない場合
     */
    public String next() {
        /*
         * nextの設計:
         * hasNextを一度も呼び出さなかった場合でも動作するようになっている 
         */
        if (nextShort == null && !hasNext()) {
            throw new NoSuchElementException();
        }
        String n = nextShort;   // nextShort を記憶する
        nextShort = null;       // nextShort を消す
        return n;               // nextShort を返す
    }

    /**
     * このイテレータ実装ではサポートしていないので、UnsupportedOperationExceptionを投げる
     * @throws UnsupportedOperationException
     */
    public void remove() {
        /*
         * removeの設計:
         * 正しく動作することができないため、利用を許さない
         */
        throw new UnsupportedOperationException();
    }
}
