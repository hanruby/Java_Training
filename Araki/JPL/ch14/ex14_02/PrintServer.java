package ch14.ex14_02;

import java.util.NoSuchElementException;

class PrintServer implements Runnable {

    private final PrintQueue requests = new PrintQueue();
    private Thread workerThread;
    
    public PrintServer() {
        workerThread = new Thread(this);
        workerThread.start();

        System.out.println("Print server started");
    }
    
    public void print(PrintJob job) {
        requests.add(job);
    }
    
    public void run() {
        if(Thread.currentThread().equals(workerThread)) {
            for(;;)
                try {
                    realPrint(requests.remove());
                } catch (NoSuchElementException e) {
                    System.out.println("Print job does not exist.");    
                }   
        }
        else {
            throw new IllegalThreadStateException("Should not invoke the run method from clients.");
        }
    }

    private void realPrint(PrintJob job) {
        System.out.println("Job printed : " + job.getName());
    }
}
