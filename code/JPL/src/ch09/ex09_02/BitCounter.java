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
    
    /**
     *  
     * @param val
     * @return
     */
    public static int bitCount2(int val) {
        int count = 0;
        for(; val!=0; val&=val-1 ){  
            count++;
        }
        return count;
    }

    public static int bitCount3(int val) {
        int num;
        num = (val >> 1) & 03333333333;
        num = val - num - ((num >> 1) & 03333333333);  
        num = ((num + (num >> 3)) & 0707070707) % 077;
        return num;
    }
    
    public static int bitCount4(int val) {
        val = (val & 0x55555555) + (val >> 1 & 0x55555555);
        val = (val & 0x33333333) + (val >> 2 & 0x33333333);
        val = (val & 0x0f0f0f0f) + (val >> 4 & 0x0f0f0f0f);
        val = (val & 0x00ff00ff) + (val >> 8 & 0x00ff00ff);
        return (val & 0x0000ffff) + (val >>16 & 0x0000ffff);
    }
}
