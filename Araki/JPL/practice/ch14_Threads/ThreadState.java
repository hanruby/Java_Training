package practice.ch14_Threads;

public class ThreadState {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread forLoopThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    lock.toString(); 
                }
            }
        }, "ForLoopThread");

        Thread sleepThread = new Thread(new Runnable() {
            public void run() {
                sleep(1000);
            }
        }, "SleepThread");

        Thread waitThread = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "WaitThread");

        printState(forLoopThread);
        forLoopThread.start();
        printState(forLoopThread);
        sleep(1000);
        printState(forLoopThread);

        printState(sleepThread);
        sleepThread.start();
        sleep(100);
        printState(sleepThread);
        sleep(1000);
        printState(sleepThread);

        synchronized (lock) {
            waitThread.start();
            sleep(100);
            printState(waitThread);
        }
        sleep(100);
        printState(waitThread);
        sleep(1000);
        printState(waitThread);
    }

    private static void sleep(long msec) {
        try {
            Thread.sleep(msec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printState(Thread t) {
        System.out.println(t.getName() + " state:" + t.getState() + " alive:"
                + t.isAlive());
    }
}