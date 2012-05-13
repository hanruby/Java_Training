package ch09.ex09_02;

/**
 * 
 * @author ato
 *
 */
public class BitCounter {

    private static int MASK = 0x00000001;
   
    /**
     * 渡されたintのビット数を数える
     * @param val
     * @return
     */
    public static int bitCount(int val) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ( (val & MASK) == MASK ) {
                count++;
            }
            val = val >>> 1;
        }
        return count;
    }
    
}
