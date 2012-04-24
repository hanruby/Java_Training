package ch04.ex04_03;

import ch03.ex03_08.Vehicle;

public class LinkedListImpl implements LinkedList {
	private Object obj;
	private LinkedListImpl next;
	
	public LinkedListImpl(Object obj) {
		this.obj = obj;
	}

	@Override
    public Object getObj() {
		return obj;
	}

	@Override
    public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
    public LinkedListImpl getNext() {
		return next;
	}

	@Override
    public void setNext(LinkedList next) {
		this.next = (LinkedListImpl)next;
	}

	@Override
	public String toString() {
		String desc = this.obj.toString();
		if (this.next != null) {
			desc += "\n   | " + this.next.toString();
		}
		return desc;
	}
	
	@Override
    public void setObjects(Object... objs) {
		LinkedListImpl l = this;
		for (Object object : objs) {
			l.next = new LinkedListImpl(object);
			l = l.next; 
		}
	}

	@Override
    public long len() {
		long length = 1;
		if (this.next != null) {
			length += this.next.len(); 
		}
		return length;
	}
	
	public static void main(String[] args) {
		LinkedListImpl l;
		
		l = new LinkedListImpl(new Vehicle(12, 90, "1号"));
		l.next = new LinkedListImpl(new Vehicle(22, 180, "2号"));
		l.next.next = new LinkedListImpl(new Vehicle(28, 210, "3号"));
		
		System.out.println(l);
	}
	
	@Override
	public LinkedListImpl clone() {
	    LinkedListImpl newList = new LinkedListImpl(this.obj);
	    if (this.next != null) {
	        newList.setNext(this.next.clone());	        
	    }
	    return newList;
	}
}

