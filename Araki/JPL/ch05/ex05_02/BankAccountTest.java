package ch05.ex05_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    BankAccount araki;

    @Before
    public void setUp() throws Exception {
        araki = new BankAccount(12345, 100); 
    }

    @Test
    public void testDeposit() {
        araki.deposit(1000);
        
        assertEquals(1100, araki.getBalance());
        assertEquals("12345: deposit 1000", araki.getLastAction().toString());
    }

    @Test
    public void testWithdraw() {
        araki.withdraw(100);
        
        assertEquals(0, araki.getBalance());
        assertEquals("12345: withdraw 100", araki.getLastAction().toString());
    }

    @Test
    public void testHistory() {
        for(int i = 0; i < 15; i++){
            araki.deposit(i);
        }
        
        // 履歴を取得する
        BankAccount.History history = araki.history();
        BankAccount.Action action;
        
        for (int i = 0; i < 10; i++) {
            action = history.next();
            assertEquals("12345: deposit "+(i+5), action.toString());
        }
        // 最後はnull
        assertEquals(history.next(), null);

        // もう一度履歴を取得する
        history = araki.history();
        
        for (int i = 0; i < 10; i++) {
            action = history.next();
            assertEquals("12345: deposit "+(i+5), action.toString());
        }
        // 最後はnull
        assertEquals(history.next(), null);
    }
}
