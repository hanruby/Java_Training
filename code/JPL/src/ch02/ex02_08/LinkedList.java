package ch02.ex02_08;


public class LinkedList {
	public Object obj = null;
	public LinkedList next = null;
	
	public LinkedList(Object obj) {
		this.obj = obj;
	}
	
	public static void main(String[] args) {
		LinkedList l = new LinkedList("root");
		LinkedList lt;
		lt = l;

		for(int i=0; i<10; i++) {
			lt.next = new LinkedList("link"+i);
			lt = lt.next;
		}
		
		LinkedList ol = l;
		
		System.out.println(ol.obj);
		
		while(ol.next != null) {
			System.out.println(ol.next.obj);
			ol = ol.next;
		}
	}
}
