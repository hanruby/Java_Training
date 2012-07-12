package ch14.ex14_08;

public class FriendlyWithYield {
    private FriendlyWithYield partner;
    private String name;

    public FriendlyWithYield(String name) {
        this.name = name;
    }

    public synchronized void hug() {
        System.out.println(Thread.currentThread().getName()+
                " in " + name + ".hug() trying to invoke " +
                partner.name + ".hugBack()");
        partner.hugBack();
    }

    private synchronized void hugBack() {
        System.out.println(Thread.currentThread().getName()+
                " in " + name + ".hugBack()");
    }

    public void becomeFriend(FriendlyWithYield partner) {
        this.partner = partner;
    }

    public static void main(String[] args) {
        final FriendlyWithYield jareth = new FriendlyWithYield("jareth");
        final FriendlyWithYield cory = new FriendlyWithYield("cory");


        jareth.becomeFriend(cory);
        cory.becomeFriend(jareth);

        new Thread(new Runnable() {
            public void run() { jareth.hug(); }
        }, "Thread1").start();

        new Thread(new Runnable() {
            public void run() { cory.hug(); }
        }, "Thread2").start();
    }
}

