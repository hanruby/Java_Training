/**
 * P.75 
 * @author ato
 *
 */
class SuperShow {
	private String str = "SuperStr";
	
	public void show() {
		System.out.println("Super.show: " + getStr());
	}
	
	public String getStr() {
		return str;
	}

	/** P.76 paragraph 5 line 1 */
	public void show(SuperShow sup) {
		System.out.println("Super.show: " + sup.str);
	}
}

class ExtendShow extends SuperShow {
	private String str = "ExtendStr";
	
	public void show() {
		System.out.println("Extend.show: " + getStr());
	}
	
	public String getStr() {
		return str;
	}

	public static void main(String[] args) {
		ExtendShow ext = new ExtendShow();
		SuperShow sup = ext;

		sup.show();
		ext.show();

		System.out.println("sup.str = " + sup.getStr());
		System.out.println("ext.str = " + ext.getStr());
		
		sup.show(ext);
	}
}