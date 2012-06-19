package ch02.ex02_12;

import static org.junit.Assert.*;
//import junit.framework.Assert;

import org.junit.Test;

import ch02.ex02_09.Vehicle;


public class LinkedListTest {

	@Test
	public void testLinkedList() {
		LinkedList l = new LinkedList("list1");
		
		assertEquals("list1", l.obj);
		assertEquals(null, l.next);
	}
	
	@Test
	public void testLinkedList2() throws Exception {
		LinkedList l = new LinkedList("list1");
		l.next = new LinkedList("list2");
		
		assertEquals("list1", l.obj);
		assertEquals("list2", l.next.obj);
		assertEquals(null, l.next.next);
	}
	
	@Test
	public void testSetObjects() throws Exception {
		LinkedList l = new LinkedList(new Vehicle(12, 90, "1号"));
		
		Vehicle v2 = new Vehicle(22, 180, "2号");
		Vehicle v3 = new Vehicle(28, 210, "3号");
		
		l.setObjects(v2,v3);
		
		assertEquals(((Vehicle)(l.obj)).getOwnerName(), "1号");
		assertEquals(((Vehicle)(l.next.obj)).getOwnerName(), "2号");
		assertEquals(((Vehicle)(l.next.next.obj)).getOwnerName(), "3号");
		
		System.out.println(l);
	}
}
