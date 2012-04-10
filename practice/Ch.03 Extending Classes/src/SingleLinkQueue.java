
public class SingleLinkQueue {
    protected Cell head;
    protected Cell tail;

    public void add(Object item) {/* ... */}
    public Object remove() {/* ... */ return null;}
}

class PriorityQueue extends SingleLinkQueue {
	// ...
    public void add(Object item) {
    }

	public void merge(PriorityQueue q) {
		Cell first = q.head;
		// ...
	}

	public void merge(SingleLinkQueue q) {
		Cell first = q.head;
		// ...
	}
}

class Cell {
    private Cell next;
    private Object element;

    public Cell(Object element) {
        this.element = element;
    }

    public Cell(Object element, Cell next) {
        this.element = element;
        this.next = next;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Cell getNext() {
        return next;
    }

    public void setNext(Cell next) {
        this.next = next;
    }
}
