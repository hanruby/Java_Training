package ch14.ex14_06;

public class TimePrinting {
    private long elapse = 0; 
    MessagePrinting message = new MessagePrinting();
    
    public TimePrinting() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        Thread.sleep(100);
                        message.count();
                        elapse++;
                        System.out.println("Elapse : " + elapse + " sec");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        message.interval(15);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    
    public static void main(String[] args) {
        new TimePrinting();
    }
}


class MessagePrinting {
    
    private long counter = 0;
    
    public synchronized void count() {
        counter++;
        notifyAll();
    }

    public synchronized void interval(int interval) throws InterruptedException {
        
        while( counter < interval ) {
            wait();
        }
        System.out.println("Interval : " + interval);

        counter = 0;
    }
}
