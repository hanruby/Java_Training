import static org.junit.Assert.*;
//import junit.framework.Assert;

import org.junit.Test;


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
		
		System.out.println(l);
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
}
