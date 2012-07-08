package ch14.ex14_02;

import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue {

    private Queue<PrintJob> que;
    
    public PrintQueue() {
        que = new LinkedList<PrintJob>();
    }
    
    public void add(PrintJob job) {
        que.add(job);
    }

    public PrintJob remove() {
        return que.remove();
    }

}
