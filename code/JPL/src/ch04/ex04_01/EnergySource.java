package ch04.ex04_01;

public interface EnergySource {
    
    /**
     * 空かどうかを返す
     * @return 空ならば true
     */
    public boolean empty();
    
    /**
     * 補給する
     * @param amount 補給量
     * @return 補給できなかった余りの量
     */
    public int charge(int amount);

    /**
     * 満タンかどうかを返す
     * @return 満タンなら true
     */
    public boolean fullness();
    
    /**
     * 残りの量を返す
     * @return 残りの量
     */
    public int remain();
}
