package ch22.ex22_02;

import java.util.BitSet;

/**
 * 文字列中に出現した文字を記録する 
 * @see JPL P.559
 */
public class WhichChars {
    /** 
     * 出現した文字を保持する<br>
     * BitSet内の各位置は、文字の数値を表す
     */
    private BitSet used = new BitSet();

    public WhichChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            used.set(str.charAt(i)); // 文字に対応したビットを設定
        }
    }

    public String toString() {
        String desc = "[";
        for (int i = used.nextSetBit(0); i >= 0; i = used.nextSetBit(i + 1)) {
            desc += (char) i;
        }
        return desc + "]";
    }
}
