package ch03.ex03_06;

public abstract class EnergySource {
    
    /**
     * 空かどうかを返す
     * @return 空ならば true
     */
    public abstract boolean empty();
    
    /**
     * 補給する
     * @param amount 補給量
     * @return 補給できなかった余りの量
     */
    public abstract int charge(int amount);

    /**
     * 満タンかどうかを返す
     * @return 満タンなら true
     */
    public abstract boolean fullness();
    
    /**
     * 残りの量を返す
     * @return 残りの量
     */
    public abstract int remain();
}
