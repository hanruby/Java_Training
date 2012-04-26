package practice.ch05_Nested_Classes_and_Interfaces;

@SuppressWarnings("unused")
public class BankAccount {
    private long number;    // 口座番号
    private long balance;   // 現在の残高（セント）
    private Action lastAct; // 最後に行われた処理

    public class Action {
        private String act;
        private long amount;
        Action(String act, long amount) {
            this.act = act;
            this.amount = amount;
        }
        public String toString() {
            // identify our enclosing account
            return number + ": " + act + " " + amount;
        }
    }

    public void deposit(long amount) {
        balance += amount;
        lastAct = new Action("deposit", amount);
    }

    public void withdraw(long amount) {
        balance -= amount;
        lastAct = new Action("withdraw", amount);
    }
    
    public static class Permissions {
        public boolean canDeposit,
                       canWithdraw,
                       canClose;
    }
    // ...
}
