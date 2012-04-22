
public class LinkedList {
	private Object obj;
	private LinkedList next;
	
	public LinkedList(Object obj) {
		this.obj = obj;
	}
	
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}

	@Override
	public String toString() {
		String desc = this.obj.toString();
		if (this.next != null) {
			desc += "\n   | " + this.next.toString();
		}
		return desc;
	}
	
	/**
	 * ex02_12 
	 * 可変長の引数で一括してobjectを登録するメソッドを書いてみた。
	 * comment: 一括で登録できるため便利だと思う。
	 * @param objs
	 */
	public void setObjects(Object... objs) {
		LinkedList l = this;
		for (Object object : objs) {
			l.next = new LinkedList(object);
			l = l.next; 
		}
	}
	
	public long len() {
		long length = 1;
		if (this.next != null) {
			length += this.next.len(); 
		}
		return length;
	}
	
	public static void main(String[] args) {
		LinkedList l;
		
		l = new LinkedList(new Vehicle(12, 90, "1号"));
		l.next = new LinkedList(new Vehicle(22, 180, "2号"));
		l.next.next = new LinkedList(new Vehicle(28, 210, "3号"));
		
		System.out.println(l);
	}
}

