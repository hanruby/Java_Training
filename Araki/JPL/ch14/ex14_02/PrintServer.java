package ch14.ex14_02;

class PrintServer implements Runnable {
    private final PrintQueue requests = new PrintQueue();
    public PrintServer() {
        new Thread(this).start();
    }
    public void print(PrintJob job) {
        requests.add(job);
    }
    public void run() {
        for(;;)
            realPrint(requests.remove());
    }
    private void realPrint(PrintJob job) {
        // do the real work of printing
    }
}
