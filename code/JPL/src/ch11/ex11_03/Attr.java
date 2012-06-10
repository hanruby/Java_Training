package ch11.ex11_03;

/**
 * P66. 名前と値の組を保持するクラス
 * @author ato
 *
 */
public class Attr<E> {
	private final String name;
	private E value = null;
	
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, E value) {
		this.name = name;
		this.value = value;
	}
	
	public final String getName() {
		return name;
	}
	
	public E getValue() {
		return value;
	}
	
	public E setValue(E newValue) {
		E oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public String toString() {
		return name + "='" + value + "'";
	}
}
