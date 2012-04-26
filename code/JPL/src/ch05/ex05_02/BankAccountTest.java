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
        araki.deposit(1000);
        araki.deposit(2000);
        araki.deposit(3000);
        araki.deposit(4000);
        araki.deposit(5000);
        araki.deposit(6000);
        araki.deposit(7000);
        araki.deposit(8000);
        araki.deposit(9000);
        araki.deposit(10000);
        araki.deposit(11000);
        araki.deposit(12000);
        
        BankAccount.History history = araki.history();
        BankAccount.Action action = history.next(); 
        while (action != null) {
            System.out.println(action);
            action = history.next();
        }
        
    }

}
