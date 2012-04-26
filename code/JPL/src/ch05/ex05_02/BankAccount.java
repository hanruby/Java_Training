package ch05.ex05_02;

/**
 * ex05_02 口座に対する最後の10個の処理を記録するBankAccount
 * @author ato
 *
 */
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
        lastAct = this.new Action("deposit", amount);
    }

    public void withdraw(long amount) {
        balance -= amount;
        lastAct = this.new Action("withdraw", amount);
    }
}
