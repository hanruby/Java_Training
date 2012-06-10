package ch12.ex12_01;

/**
 * ex04_03 LinkedListはインターフェースで定義されるべき。
 * 理由：
 *  - LinkedListは他のクラスで拡張される可能性があるため。
 * ex11_01 ジェネリックで書きなおし。
 * @author ato
 *
 */
public interface LinkedList<E> extends Cloneable {

    public abstract E getObj();
    public abstract void setObj(E obj);
    public abstract LinkedList<E> getNext();
    public abstract void setNext(LinkedList<E> next);
    public abstract String toString();

    /**
     * ex02_12 
     * 可変長の引数で一括してobjectを登録するメソッドを書いてみた。
     * comment: 一括で登録できるため便利だと思う。
     * @param objs
     */
    public abstract void setObjects(E... objs);
    public abstract long len();

    /**
	 * ex.3.10 clone
	 * 値の複製でなく、元のリストと同じ値を参照している新たなリストを返す。
	 * ひとつのリストに対する変更は、他方のリストには影響しないが、リストが参照しているオブジェクトに対する変更は、他方のリストから見える。
	 */
    public abstract LinkedList<E> clone();
}