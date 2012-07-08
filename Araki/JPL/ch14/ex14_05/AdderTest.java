package ch14.ex14_05;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdderTest {
    int condition;
    
    final int THREAD_NUM = 4;
    final int COUNT_NUM = 10000;
    final int ADD_NUM = 1;
    final int SUB_NUM = 2;
    
    @Before
    public void setUp() throws Exception {
        condition = 0;
    }

    @Test
    public void testAdder() throws Exception {
        // Create some threads 
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Start :" + Thread.currentThread().getName());
                    for (int j = 0; j < COUNT_NUM; j++) {
                        Adder.add(ADD_NUM);
                    }
                    System.out.println("End :" + Thread.currentThread().getName());
                    condition++;
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Start :" + Thread.currentThread().getName());
                    for (int j = 0; j < COUNT_NUM; j++) {
                        Adder.sub(SUB_NUM);
                    }
                    System.out.println("End :" + Thread.currentThread().getName());
                    condition++;
                }
            }).start();
        }
        
        while(condition != THREAD_NUM * 2) { 
            Thread.sleep(100);
        }
        // THREAD_NUM threads x COUNT_NUM times
        assertEquals(THREAD_NUM * COUNT_NUM * ADD_NUM - THREAD_NUM * COUNT_NUM * SUB_NUM, Adder.getNum());
    }
}
