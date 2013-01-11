package ch22.ex22_03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 文字列中に出現した文字を記録する
 * 
 * @see JPL P.559
 */
public class WhichChars {
    /**
     * 出現した文字を保持する<br>
     * 上位8ビットをキーへ保存し、下位ビットをBitSetへ保存する
     */
    private Map<Byte, BitSet> usedMap = new HashMap<Byte, BitSet>();

    private static int shift = (21-8); // Unicode 
    
    public WhichChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);

            byte topByte = (byte) ((c >>> shift) & 0xFF); // 上位8ビット
            int lowBytes = (int) (c & 0xFFFF); // 下位ビット

            // Mapに上位バイトが格納されている場合
            if (usedMap.containsKey(topByte)) {
                // Mapに保存されているBitSetオブジェクトへ、下位ビットを追加する
                BitSet used = usedMap.get(topByte);
                used.set(lowBytes); // 下位ビットを追加
            }
            // Mapに上位バイトが格納されてない場合
            else {
                // 新規にBitSetオブジェクトを生成し、Mapへ保存する
                BitSet used = new BitSet();
                used.set(lowBytes); // 下位ビットを設定
                usedMap.put(topByte, used);
            }
        }
    }

    public String toString() {

        StringBuilder desc = new StringBuilder();
        desc.append("[");
        
        for (Map.Entry<Byte, BitSet> entry : usedMap.entrySet()) {
            byte topByte = entry.getKey();
            BitSet used = entry.getValue();
            
            for (int lowBytes = used.nextSetBit(0); lowBytes >= 0; lowBytes = used.nextSetBit(lowBytes + 1)) {
                char ch;
                ch = (char) (topByte << shift); // 上位バイトをシフト
                ch |= (char) lowBytes; // 下位バイトを接続
                desc.append(ch);
            }
        }
        desc.append("]");
        return desc.toString();
    }
}
