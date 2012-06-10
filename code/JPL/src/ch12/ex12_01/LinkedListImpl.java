package ch12.ex12_01;

import ch03.ex03_08.Vehicle;

public class LinkedListImpl<E> implements LinkedList<E> {
	private E obj;
	private LinkedListImpl<E> next;
	
	public LinkedListImpl(E obj) {
		this.obj = obj;
	}

	@Override
    public E getObj() {
		return obj;
	}

	@Override
    public void setObj(E obj) {
		this.obj = obj;
	}

	@Override
    public LinkedListImpl<E> getNext() {
		return next;
	}

	@Override
    public void setNext(LinkedList<E> next) {
		this.next = (LinkedListImpl<E>)next;
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
    public void setObjects(E... objs) {
		LinkedListImpl<E> l = this;
		for (E object : objs) {
			l.next = new LinkedListImpl<E>(object);
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
		LinkedListImpl<Vehicle> l;
		
		l = new LinkedListImpl<Vehicle>(new Vehicle(12, 90, "1号"));
		l.next = new LinkedListImpl<Vehicle>(new Vehicle(22, 180, "2号"));
		l.next.next = new LinkedListImpl<Vehicle>(new Vehicle(28, 210, "3号"));
		
		System.out.println(l);
	}
	
	@Override
	public LinkedListImpl<E> clone() {
	    LinkedListImpl<E> newList = new LinkedListImpl<E>(this.obj);
	    if (this.next != null) {
	        newList.setNext(this.next.clone());	        
	    }
	    return newList;
	}

    @Override
    public LinkedList<E> find(E obj) throws ObjectNotFoundException {
        LinkedListImpl<E> l = this.clone();
        while(l != null) {
            if( l.obj.equals(obj) ) {
                return l;
            }
            l = l.next;
        }
        throw new ObjectNotFoundException(obj.toString());
    }
}

