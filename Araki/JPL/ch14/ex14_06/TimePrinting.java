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
                        Thread.sleep(500);
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
    }
    
    public void addInterval(final int interval) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        message.interval(interval);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    
    public long getElapse() {
        return elapse;
    }
}


class MessagePrinting {
    
    private long count = 0;
    private long count_plus = 1;
    
    public synchronized void count() {
        count++;
        notifyAll();
    }

    public synchronized void interval(int interval) throws InterruptedException {
        
        while( count % interval != 0 || count_plus > count) {
            wait();
        }
        System.out.println("Interval : " + interval);
        count_plus = count + 1;
    }
}
