package ch11.ex11_01;

/**
 * ex04_03 LinkedListはインターフェースで定義されるべき。
 * 理由：
 *  - LinkedListは他のクラスで拡張される可能性があるため。
 * @author ato
 *
 */
public interface LinkedList extends Cloneable {

    public abstract Object getObj();
    public abstract void setObj(Object obj);
    public abstract LinkedList getNext();
    public abstract void setNext(LinkedList next);
    public abstract String toString();

    /**
     * ex02_12 
     * 可変長の引数で一括してobjectを登録するメソッドを書いてみた。
     * comment: 一括で登録できるため便利だと思う。
     * @param objs
     */
    public abstract void setObjects(Object... objs);
    public abstract long len();

    /**
	 * ex.3.10 clone
	 * 値の複製でなく、元のリストと同じ値を参照している新たなリストを返す。
	 * ひとつのリストに対する変更は、他方のリストには影響しないが、リストが参照しているオブジェクトに対する変更は、他方のリストから見える。
	 */
    public abstract LinkedList clone();
}