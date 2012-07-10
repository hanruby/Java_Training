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
    
    private long counter = 0;
    private long version_no = 1;
    
    public synchronized void count() {
        counter++;
        notifyAll();
    }

    public synchronized void interval(int interval) throws InterruptedException {
        
        while( counter % interval != 0 || version_no > counter) {
            //System.out.println("hoge" + version_no);
            wait();
        }
        System.out.println("Interval : " + interval);
        version_no = counter+1;
    }
}
