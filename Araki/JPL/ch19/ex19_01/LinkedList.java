package ch19.ex19_01;

import ch02.ex02_15.Vehicle;

/**
 * LinkedList 
 */
public class LinkedList {
	private Object obj;
	private LinkedList next;
	
	/**
	 * @param obj LinkedListへ格納するオブジェクト
	 */
	public LinkedList(Object obj) {
		this.obj = obj;
	}
	
	/**
	 * LinkedListで保持しているオブジェクトを返すメソッド
	 * @return このリンクで保持しているオブジェクト
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * LinkedListへオブジェクトを保持するメソッド
	 * @param obj LinkedListへ保持するオブジェクト
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/**
	 * 次のLinkedListを返すメソッド
	 * @return 次のLinkedList
	 */
	public LinkedList getNext() {
		return next;
	}

	/**
	 * 次のLinkedListをセットするメソッド
	 * @param next 次のLinkedList
	 */
	public void setNext(LinkedList next) {
		this.next = next;
	}

	/**
	 * LinkedListの内容を文字列へ変換するメソッド
	 * @return LinkedListの内容の文字列
	 */
	@Override
	public String toString() {
		String desc = this.obj.toString();
		if (this.next != null) {
			desc += "\n   | " + this.next.toString();
		}
		return desc;
	}
	
	/**
	 * 可変長の引数で一括してObjectを登録するメソッド
	 * @param objs 登録する複数のオブジェクト
	 */
	public void setObjects(Object... objs) {
		LinkedList l = this;
		for (Object object : objs) {
			l.next = new LinkedList(object);
			l = l.next; 
		}
	}
	
	/**
	 * LinkedListの長さを返すメソッド
	 * @return LinkedListの長さ
	 */
	public long len() {
		long length = 1;
		if (this.next != null) {
			length += this.next.len(); 
		}
		return length;
	}

	/**
	 * サンプルプログラム
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList l;
		
		l = new LinkedList(new Vehicle(12, 90, "1号"));
		l.next = new LinkedList(new Vehicle(22, 180, "2号"));
		l.next.next = new LinkedList(new Vehicle(28, 210, "3号"));
		
		System.out.println(l);
	}
}

