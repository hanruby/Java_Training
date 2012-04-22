package practice.ch03_Extending_Classes;

/**
 * P66. 名前と値の組を保持するクラス
 * @author ato
 *
 */
public class Attr {
	private final String name;
	private Object value = null;
	
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public final String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public String toString() {
		return name + "='" + value + "'";
	}
}
