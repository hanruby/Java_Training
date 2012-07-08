package ch14.ex14_02;

import java.util.NoSuchElementException;

class PrintServer implements Runnable {

    private final PrintQueue requests = new PrintQueue();
    
    public PrintServer() {
        new Thread(this).start();

        System.out.println("Print server started");
    }
    
    public void print(PrintJob job) {
        requests.add(job);
    }
    
    public void run() {
        for(;;)
            try {
                realPrint(requests.remove());
            } catch (NoSuchElementException e) {
                System.out.println("Print job does not exist.");    
            }   
    }
    
    private void realPrint(PrintJob job) {
        System.out.println("Job printed : " + job.getName());
    }
}
