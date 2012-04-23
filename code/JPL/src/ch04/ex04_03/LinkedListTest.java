package ch04.ex04_03;

import static org.junit.Assert.*;
//import junit.framework.Assert;

import org.junit.Test;

import ch03.ex03_08.Vehicle;


public class LinkedListTest {

	@Test
	public void testLinkedList() {
		LinkedList l = new LinkedList("list1");
		
		assertEquals("list1", l.getObj());
		assertEquals(null, l.getNext());
	}
	
	@Test
	public void testLinkedList2() throws Exception {
		LinkedList l = new LinkedList("list1");
		l.setNext(new LinkedList("list2"));
		
		assertEquals("list1", l.getObj());
		assertEquals("list2", l.getNext().getObj());
		assertEquals(null, l.getNext().getNext());
	}
	
	@Test
	public void testSetObjects() throws Exception {
		LinkedList l = new LinkedList(new Vehicle(12, 90, "1号"));
		
		Vehicle v2 = new Vehicle(22, 180, "2号");
		Vehicle v3 = new Vehicle(28, 210, "3号");
		
		l.setObjects(v2,v3);
		
		assertEquals(((Vehicle)(l.getObj())).getOwnerName(), "1号");
		assertEquals(((Vehicle)(l.getNext().getObj())).getOwnerName(), "2号");
		assertEquals(((Vehicle)(l.getNext().getNext().getObj())).getOwnerName(), "3号");
	}
	
	@Test
	public void testLen() throws Exception {
		LinkedList l = new LinkedList(new Vehicle(12, 90, "1号"));
		
		Vehicle v2 = new Vehicle(22, 180, "2号");
		Vehicle v3 = new Vehicle(28, 210, "3号");
		Vehicle v4 = new Vehicle(28, 210, "4号");
		
		l.setObjects(v2,v3,v4);
		
		assertEquals(l.len(), 4);

	}

	@Test
    public void testClone() throws Exception {
		LinkedList l1 = new LinkedList(new Vehicle(12, 90, "1号"));
		
		Vehicle v2 = new Vehicle(22, 180, "2号");
		Vehicle v3 = new Vehicle(28, 210, "3号");
		Vehicle v4 = new Vehicle(28, 210, "4号");
		
		l1.setObjects(v2,v3,v4);
        
		LinkedList l2 = l1.clone();

		Vehicle v5 = new Vehicle(69, 20, "5号");
		
		// 2号と3号の間に要素を挿入
		LinkedList tmp = new LinkedList(v5);
		tmp.setNext(l1.getNext().getNext());
		l1.getNext().setNext(tmp);

		// 1つめのListの要素をかえてみる
		((Vehicle)l1.getNext().getNext().getNext().getObj()).setOwnerName("3号改");

		// 1つめのListの要素の確認
		String result1 = "";
	    for (LinkedList it = l1; it != null; it = it.getNext()) {
	        result1 += " " + ((Vehicle)it.getObj()).getOwnerName();
	    }
	    assertEquals(" 1号 2号 5号 3号改 4号", result1);

	    // 2つめのListの要素の確認
	    String result2 = "";
	    for (LinkedList it = l2; it != null; it = it.getNext()) {
	        result2 += " " + ((Vehicle)it.getObj()).getOwnerName();
	    }
	    assertEquals(" 1号 2号 3号改 4号", result2);
    }
}
