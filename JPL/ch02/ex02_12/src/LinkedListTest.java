import static org.junit.Assert.*;
//import junit.framework.Assert;

import org.junit.Test;


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
}
