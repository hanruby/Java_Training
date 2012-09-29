package ch22.ex22_04;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

public class AttributedImplTest {

    class SimpleAttrObserver implements Observer {

        AttributedImpl watching;

        public SimpleAttrObserver(AttributedImpl attributed) {
            watching = attributed;
            watching.addObserver(this);
        }

        @Override
        public void update(Observable attributed, Object changeAttr) {
            if (attributed != watching) {
                throw new IllegalArgumentException();
            }

            String message = (String) changeAttr;

            messages.append(message);
            messages.append("\n");
        }

        private StringBuilder messages = new StringBuilder();

        public String getMessages() {
            return messages.toString();
        }
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test_can_get_notify() throws Exception {
        AttributedImpl attributed = new AttributedImpl();

        attributed.add(new Attr("one", 1));
        attributed.add(new Attr("two", 2));

        SimpleAttrObserver observer = new SimpleAttrObserver(attributed);

        attributed.add(new Attr("three", 3));
        attributed.add(new Attr("four", 4));

        attributed.remove("one");
        attributed.remove("two");

        assertEquals("Add attr object : three\n" +
                     "Add attr object : four\n" +
                     "Remove attr object : one\n" +
                     "Remove attr object : two\n", 
                     observer.getMessages());
    }
}
