package practice.ch14_Threads;

class PrintServer2 {
    private final PrintQueue requests = new PrintQueue();
    public PrintServer2() {
        Runnable service = new Runnable() {
            public void run() {
                for(;;)
                    realPrint(requests.remove());
            }
        };
        new Thread(service).start();
    }
    public void print(PrintJob job) {
        requests.add(job);
    }
    private void realPrint(PrintJob job) {
        // do the real work of printing
    }
}
