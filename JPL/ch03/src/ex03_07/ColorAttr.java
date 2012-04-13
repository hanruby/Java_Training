package ex03_07;
/**
 * P.67 色を特定あるいは記述する文字列として色属性を保存するために、Attrを拡張したクラス
 * @author ato
 *
 */
public class ColorAttr extends Attr{
	private ScreenColor myColor; // 変換された色
	
	public ColorAttr(String name, Object value) {
		super(name, value); // P.69 スーパークラス・コンストラクタ呼び出し(superclass constructor invocation)
		decodeColor();
	}
	
	public ColorAttr(String name) {
		this(name, "transparent"); // P.69 自分のコンストラクタのひとつを呼び出す
	}
	
	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}
	
	public Object setValue(Object newValue) {
		// スーパークラスの setValue を最初におこなう
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	
	/** 値を記述ではなく ScreenColor に設定する */
	public ScreenColor setValue(ScreenColor newValue) {
		// スーパークラスの setValue を最初におこなう
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	/** 変換された ScreenColor オブジェクトを返す */
	public ScreenColor getColor() {
		return myColor;
	}
	
	/** getValue() で得られる記述から ScreenColor を設定する */
	protected void decodeColor() {
		if (getValue() == null) {
			myColor = null;
		}
		else {
			myColor = new ScreenColor(getValue());
		}
			
	}
}
