package ch21.ex21_04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ShortStrings implements Iterator<String> {
    private Iterator<String> strings;  // 元の文字列
    private String nextShort;      // 次が不明ならnull
    private final int maxLen;      // この長さ以下の文字列を返す

    public ShortStrings(Iterator<String> strings,
                        int maxLen) {
        this.strings = strings;
        this.maxLen = maxLen;
        nextShort = null;
    }

    public boolean hasNext() {
        if (nextShort != null)  // すでに見つけた
            return true;
        while (strings.hasNext()) {
            nextShort = strings.next();
            if (nextShort.length() <= maxLen)
                return true;
        }
        nextShort = null;       // 見つからなかった
        return false;
    }

    public String next() {
        if (nextShort == null && !hasNext())
            throw new NoSuchElementException();
        String n = nextShort;   // nextShort を記憶する
        nextShort = null;       // nextShort を消す
        return n;               // nextShort を返す
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
