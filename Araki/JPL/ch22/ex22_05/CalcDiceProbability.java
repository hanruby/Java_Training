package ch22.ex22_05;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalcDiceProbability {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void calcDiceProbability_sum() throws Exception {
        
        int DICE_NUM = 10000;
        
        Dice[] dices = new Dice[DICE_NUM];
        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
        }
        
        int sum = 0;
        for (int i = 0; i < DICE_NUM; i++) {
            sum += dices[i].shoot();
        }
        System.out.println(sum);
    }
    
    @Test
    public void calcDiceProbability_roll() throws Exception {
        
        int ROLL_TIME = 10000;
        
        Dice dice = new Dice();
        
        int sum = 0;
        for (int i = 0; i < ROLL_TIME; i++) {
            sum += dice.shoot();
        }
        System.out.println(sum);
    }

}
