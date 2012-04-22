package ch02.ex02_06;

import ch02.ex02_05.Vehicle;

public class LinkedList {
	public Object obj;
	public LinkedList next;
	
	public LinkedList(Object obj) {
		this.obj = obj;
	}
	
	public static void main(String[] args) {
		LinkedList l;
		
		l = new LinkedList(new Vehicle(12, 90, "1号"));
		l.next = new LinkedList(new Vehicle(22, 180, "2号"));
		l.next.next = new LinkedList(new Vehicle(28, 210, "3号"));

		((Vehicle)l.obj).show();
		((Vehicle)l.next.obj).show();
		((Vehicle)l.next.next.obj).show();
	}
}

