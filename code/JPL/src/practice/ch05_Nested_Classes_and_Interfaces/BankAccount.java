package practice.ch05_Nested_Classes_and_Interfaces;

@SuppressWarnings("unused")
public class BankAccount {
    private long number;    // 口座番号
    private long balance;   // 現在の残高（セント）

    public static class Permissions {
        public boolean canDeposit,
                       canWithdraw,
                       canClose;
    }
    // ...
}
