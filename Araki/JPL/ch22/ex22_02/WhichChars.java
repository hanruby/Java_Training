package ch22.ex22_02;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 文字列中に出現した文字を記録する 
 * @see JPL P.559
 */
public class WhichChars {
    /** 
     * 出現した文字を保持する
     */
    private Set<Character> used = new HashSet<Character>();

    public WhichChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            used.add(str.charAt(i)); // 文字に対応したビットを設定
        }
    }

    public String toString() {
        // HashSetで保存するとhash値で並ぶだけで、ソートされない。
        // そのため、TreeSetでソートする
        Set<Character> sorted = new TreeSet<Character>(used);
                
        StringBuilder desc = new StringBuilder();
        desc.append("[");
        for (Character ch : sorted) {
            desc.append(ch);
        }
        desc.append("]");
        return desc.toString();
    }
}
