package ch02.ex02_02;


public class LinkedList {
	public Object obj;
	public LinkedList next;
	
	public LinkedList(Object obj) {
		this.obj = obj;
	}
	
	public static void main(String[] args) {
		LinkedList l = new LinkedList("list");
		LinkedList lt;
		lt = l;

		for(int i=0; i<10; i++) {
			lt.next = new LinkedList("link"+i);
			lt = lt.next;
		}

		System.out.println(l.obj);
		System.out.println(l.next.obj);
		System.out.println(l.next.next.obj);
		System.out.println(l.next.next.next.next.next.obj);
	}
}
