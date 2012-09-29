package ch22.ex22_05;

import java.util.Random;

/**
 * サイコロクラス
 * @author ato
 *
 */
public class Dice {

    private Random rand = new Random();
    
    /** 目の数 */
    public static final int SIDED_DIE_NUM = 6;
        
    /**
     * サイコロを振る
     * @return 1-6まで
     */
    public int shoot() {
        return rand.nextInt(SIDED_DIE_NUM) + 1; 
    }
}
