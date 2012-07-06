package ch05.ex05_02;

import java.util.Iterator;
import java.util.Queue;        
import java.util.LinkedList;        

/**
 * ex05_02 口座に対する最後の10個の処理を記録するBankAccount
 * @author ato
 *
 */
public class BankAccount {
    private long number;    // 口座番号
    private long balance;   // 現在の残高（セント）
    private Action lastAct; // 最後に行われた処理

    private History history = new History(); // 履歴
    private final static int HISTORY_SIZE = 10; // 履歴の最大保持件数

    /**
     * open a new account at a bank
     * @param number 口座番号
     * @param balance 口座開設金額
     */
    public BankAccount(long number, long balance) {
        this.number = number;
        this.balance = balance;
    }
    
    /**
     * 口座に対して１つの処理を記録するクラス
     */
    public class Action {
        private String act;  // 処理の内容
        private long amount; // 額
        Action(String act, long amount) {
            this.act = act;
            this.amount = amount;
        }
        public String toString() {
            // identify our enclosing account
            return number + ": " + act + " " + amount;
        }
    }
    
    /**
     * ex05_02 口座に対する10個の処理を記録するクラス。
     * 
     * 本クラスは、内部クラスであることが望ましい。
     * （BankAccountクラスに依存しているため（ひとつのBankAccountに対してひとつのHistoryを持つ））
     * また、staticのネストではない方が良い。
     * （Historyに直接アクセスできないほうが好ましいため）
     */
    public class History {
        /*
         * I learned a example of use of Queue interface from here:
         * http://www.easywayserver.com/blog/java-queue-example/
         * http://java.sun.com/javase/ja/6/docs/ja/api/java/util/Queue.html
         */ 
        private Queue<Action> history = new LinkedList<Action>();
        private Iterator<Action> it;

        /**
         * Actionオブジェクトを１つ返す。リストの最後はnull。
         */
        public Action next() {
            if(it == null) {
                it = history.iterator();
            }
            if(it.hasNext()) {
                return it.next();
            }
            else {
                return null;
            }
        }

        /**
         * 取引を保存する
         * @param lastAct
         */
        public void saveAction(Action lastAct) {
            if(history.size() >= HISTORY_SIZE) {
                // TODO: 内部ではさらに履歴を持つ
                history.poll();
            }
            history.add(lastAct);
        }
    }

    /**
     * 預金する
     * @param amount 預金する額
     */
    public void deposit(long amount) {
        balance += amount;
        lastAct = this.new Action("deposit", amount);
        history.saveAction(lastAct);
    }

    /**
     * 預金をおろす
     * @param amount 引き出す額 
     */
    public void withdraw(long amount) {
        balance -= amount;
        lastAct = this.new Action("withdraw", amount);
        history.saveAction(lastAct) ;
    }

    /**
     * 最終取引の内容を取り出す
     * @return
     */
    public Action getLastAction() {
        return lastAct;
    }

    public long getBalance() {
        return balance;
    }

    /**
     * 履歴を取り出す
     * @return
     */
    public History history() {
        return this.history;
        //TODO: clone
    }
}
