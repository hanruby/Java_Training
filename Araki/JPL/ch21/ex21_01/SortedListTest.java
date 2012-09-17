package ch21.ex21_01;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class SortedListTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void test_ファイルが読めるか() throws Exception {
        File file = new File("JPL/ch21/ex21_01/testfile.txt");

        SortedList list = new SortedList();
        list.readFile(file);
    }

    @Test
    public void test_ソートできるか() throws Exception {
        File file = new File("JPL/ch21/ex21_01/testfile.txt");

        SortedList list = new SortedList();
        list.readFile(file);
        
        assertEquals("aaa", list.pop());
        assertEquals("aac", list.pop());
        assertEquals("abb", list.pop());
        assertEquals("abc", list.pop());
        assertEquals("baa", list.pop());
        assertEquals("bbb", list.pop());
    }
}
