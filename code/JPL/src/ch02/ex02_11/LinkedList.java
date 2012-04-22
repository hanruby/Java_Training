package ch02.ex02_11;

import ch02.ex02_10.*;

public class LinkedList {
	public Object obj;
	public LinkedList next;
	
	public LinkedList(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public String toString() {
		String desc = this.obj.toString();
		if (this.next != null) {
			desc += "\n   | " + this.next.toString();
		}
		return desc;
	}
	
	public static void main(String[] args) {
		LinkedList l;
		
		l = new LinkedList(new Vehicle(12, 90, "1号"));
		l.next = new LinkedList(new Vehicle(22, 180, "2号"));
		l.next.next = new LinkedList(new Vehicle(28, 210, "3号"));
		
		System.out.println(l);
	}
}

