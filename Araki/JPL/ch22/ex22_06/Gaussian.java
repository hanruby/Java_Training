package ch22.ex22_06;

import java.util.Random;

public class Gaussian {

    public static final int TRIALS_NUM = 10000;
    public static final int DIVIDE_NUM = 30; 
    
    private static final double MAX_RANGE = 4.0;
    private static final double MIN_RANGE = -4.0;
    
    private int[] score = new int[DIVIDE_NUM];
    private double[] normalizedData = new double[DIVIDE_NUM];

    private Random rand = new Random();
    
    public void run() {
        double resolution = (MAX_RANGE - MIN_RANGE)/DIVIDE_NUM;

        for (int i = 0; i < TRIALS_NUM; i++) {
            double value = rand.nextGaussian();
            for (int pos = 0; pos < DIVIDE_NUM; pos++) {
                if ( (resolution * (pos) + MIN_RANGE <= value) &&
                     (value < resolution * (pos + 1) + MIN_RANGE) ) {
                    score[pos]++;
                }
            }
        }
        
        calcNormalize();
    }
    
    private void calcNormalize() {
        for (int i = 0; i < DIVIDE_NUM; i++) {
            normalizedData[i] = (double)score[i]/TRIALS_NUM;
        }
    }

    public void show() {
        for (int i = 0; i < DIVIDE_NUM; i++) {
            System.out.println(normalizedData[i]);
        }
    }
    
    public double[] getData() {
        return normalizedData;
    }

    public static void main(String[] args) {
        Gaussian g = new Gaussian();
        g.run();
        g.show();
    }


}
